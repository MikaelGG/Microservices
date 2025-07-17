package com.microservice_webs.service;

import com.microservice_webs.dto.ClientDTO;
import com.microservice_webs.dto.InvoicesDTO;
import com.microservice_webs.model.Invoices;
import com.microservice_webs.model.WebPages;
import com.microservice_webs.repository.InvoicesRepository;
import com.microservice_webs.repository.WebPagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InvoicesService {

    @Autowired
    InvoicesRepository invoicesRepository;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    WebPagesRepository webPagesRepository;

    @Transactional
    public Invoices saveInvoice(Invoices invoice) {

        if (invoice.getIssueDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("The issue date cannot be before the current date.");
        }

        return invoicesRepository.save(invoice);
    }

    @Transactional(readOnly = true)
    public List<InvoicesDTO> getInvoices() {
        List<Invoices> invoices = invoicesRepository.findAll();
        return invoices.stream().map(invoice -> {
            InvoicesDTO invoiceDTO = new InvoicesDTO();
            invoiceDTO.setIssueDate(invoice.getIssueDate());
            WebPages webPages = webPagesRepository.findById(invoice.getIdWebPage().getId()).orElseThrow(() -> new RuntimeException("WebPage not found with id: " + invoice.getIdWebPage().getId()));
            invoiceDTO.setIdWebPage(webPages);
            invoiceDTO.setIdClient(restTemplate.getForObject("https://microservice-client.up.railway.app/api/clients/" + invoice.getIdClient(), ClientDTO.class));
            return invoiceDTO;
        }).toList();
    }

    @Transactional(readOnly = true)
    public InvoicesDTO getInvoiceById(Long id) {
        Invoices invoices = invoicesRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice not found with id: " + id));
        InvoicesDTO invoiceDTO = new InvoicesDTO();
        invoiceDTO.setIssueDate(invoices.getIssueDate());
        WebPages webPages = webPagesRepository.findById(invoices.getIdWebPage().getId()).orElseThrow(() -> new RuntimeException("WebPage not found with id: " + invoices.getIdWebPage().getId()));
        invoiceDTO.setIdWebPage(webPages);
        invoiceDTO.setIdClient(restTemplate.getForObject("https://microservice-client.up.railway.app/api/clients/" + invoices.getIdClient(), ClientDTO.class));
        return invoiceDTO;
    }

    @Transactional
    public Invoices updateInvoice(Long id, Invoices invoice) {

        Invoices existingInvoice = invoicesRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice not found with id: " + id));

        if (invoice.getIssueDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("The issue date cannot be before the current date.");
        }

        existingInvoice.setIssueDate(invoice.getIssueDate());
        existingInvoice.setIdWebPage(invoice.getIdWebPage());
        existingInvoice.setIdClient(invoice.getIdClient());

        return invoicesRepository.save(existingInvoice);
    }

    @Transactional
    public String deleteInvoice(Long id) {

        if (!invoicesRepository.existsById(id)) {
            throw new RuntimeException("Invoice not found with id: " + id);
        }
        invoicesRepository.deleteById(id);

        return "Invoice deleted successfully with id: " + id;
    }
}
