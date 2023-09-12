package com.company.billaris2.mappers;

import com.company.billaris2.DTO.ClientDTO;
import com.company.billaris2.entities.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientMapper {

    private final AddressMapper addressMapper;



    public ClientDTO toDTO(Client client) {
        ClientDTO dto = new ClientDTO();
//        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setEmail(client.getEmail());
        dto.setPhoneNumber(client.getPhoneNumber());
        dto.setAddress(addressMapper.toDTO(client.getAddress()));
        return dto;
    }

    public Client toEntity(ClientDTO dto) {
        Client client = new Client();
//        client.setId(dto.getId());
        client.setName(dto.getName());
        client.setEmail(dto.getEmail());
        client.setPhoneNumber(dto.getPhoneNumber());
//        client.setAddress(addressMapper.toEntity(dto.getAddress()));
        return client;
    }
}
