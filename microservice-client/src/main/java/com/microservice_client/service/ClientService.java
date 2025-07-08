package com.microservice_client.service;

import com.microservice_client.model.ClientModel;
import com.microservice_client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Transactional
    public ClientModel saveClient(ClientModel clientModel) {
        if (clientRepository.existsById(clientModel.getDocumentId())) throw new RuntimeException("Client alredy exists");

        return clientRepository.save(clientModel);
    }

    @Transactional(readOnly = true)
    public List<ClientModel> getAllClients() {
        return clientRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ClientModel getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @Transactional
    public ClientModel updateClient(Long id, ClientModel clientModel) {

        ClientModel client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));

        client.setDocumentId(clientModel.getDocumentId());
        client.setName(clientModel.getName());
        client.setLastname(clientModel.getLastname());
        client.setPhone(clientModel.getPhone());
        client.setAge(clientModel.getAge());
        client.setEmail(clientModel.getEmail());

        return clientRepository.save(client);

    }

    @Transactional
    public String deleteClient(Long id) {
        if (!clientRepository.existsById(id)) throw new RuntimeException("Client not found");;
        clientRepository.deleteById(id);
        return "Cliente deleted";
    }

}
