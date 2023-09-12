package com.company.billaris2.services.interfaces;

import com.company.billaris2.DTO.ClientDTO;
import com.company.billaris2.entities.Client;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClientService {
    Client createClient(ClientDTO clientDTO);

    Client getClientById(Long clientId);

    List<Client> getAllClients();

    Client updateClient(Long id, ClientDTO clientDTO);

    void deleteClient(Long id);
}
