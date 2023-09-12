package com.company.billaris2.services.impl;

import com.company.billaris2.DTO.AddressDTO;
import com.company.billaris2.DTO.ClientDTO;
import com.company.billaris2.entities.Address;
import com.company.billaris2.entities.Client;
import com.company.billaris2.repositories.AddressRepository;
import com.company.billaris2.repositories.ClientRepository;
import com.company.billaris2.services.interfaces.AddressService;
import com.company.billaris2.services.interfaces.ClientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;
    private final AddressRepository addressRepository;
    private final AddressService addressService;



    @Override
    public Client createClient(ClientDTO clientDTO) {
        Address address = addressRepository.findByStreet(clientDTO.getAddress().getStreet());
        if (address == null){

            address = addressService.createAddress(clientDTO.getAddress());
            addressRepository.save(address);
        }
        Client client = modelMapper.map(clientDTO, Client.class);
        client.setAddress(address);

        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client updateClient(Long id, ClientDTO clientDTO) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client existingClient = optionalClient.get();
            modelMapper.map(clientDTO, existingClient);
            return clientRepository.save(existingClient);
        }
        return null;
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
