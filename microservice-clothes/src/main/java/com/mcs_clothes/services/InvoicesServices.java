package com.mcs_clothes.services;

import com.mcs_clothes.clients.ClientFeignClothes;
import com.mcs_clothes.dto.InvoicesDTO;
import com.mcs_clothes.model.InvoicesModel;
import com.mcs_clothes.repository.InvoicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InvoicesServices {

    @Autowired
    InvoicesRepository invoicesRepository;
    @Autowired
    ClientFeignClothes clientFeignClothes;

    @Transactional
    public InvoicesModel saveInvoice(InvoicesModel invoicesModel) {
        System.out.println("Saving invoice: " + invoicesModel);
        if (invoicesModel.getIssueDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Issue date cannot be in the past");
        }
        return invoicesRepository.save(invoicesModel);
    }

    @Transactional(readOnly = true)
    public List<InvoicesDTO> getAllInvoices() {
        List<InvoicesModel> invoicesModel = invoicesRepository.findAll();
        System.out.println(invoicesModel);
        return invoicesModel.stream().map(invoice -> {
            InvoicesDTO invoicesDTO = new InvoicesDTO();
            invoicesDTO.setIssueDate(invoice.getIssueDate());
            invoicesDTO.setProduct(invoice.getProduct());
            invoicesDTO.setIdClient(clientFeignClothes.getClientById(invoice.getIdClient()));
            invoicesDTO.setTotal(invoice.getTotal());
            return invoicesDTO;
        }).toList();
    }

    @Transactional(readOnly = true)
    public InvoicesDTO getInvoiceById(Long id) {
        InvoicesModel invoice = invoicesRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice not found with id: " + id));
        InvoicesDTO invoiceDTO = new InvoicesDTO();
        invoiceDTO.setIssueDate(invoice.getIssueDate());
        invoiceDTO.setProduct(invoice.getProduct());
        invoiceDTO.setIdClient(clientFeignClothes.getClientById(invoice.getIdClient()));
        invoiceDTO.setTotal(invoice.getTotal());
        return invoiceDTO;
    }

    @Transactional
    public InvoicesModel updateInvoice(Long id, InvoicesModel invoicesModel) {
        InvoicesModel existingInvoice = invoicesRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice not found with id: " + id));
        if (invoicesModel.getIssueDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Issue date cannot be in the past");
        }
        existingInvoice.setProduct(invoicesModel.getProduct());
        existingInvoice.setIssueDate(invoicesModel.getIssueDate());
        existingInvoice.setTotal(invoicesModel.getTotal());
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
