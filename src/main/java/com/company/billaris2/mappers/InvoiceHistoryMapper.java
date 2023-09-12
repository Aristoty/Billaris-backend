package com.company.billaris2.mappers;

import com.company.billaris2.DTO.InvoiceHistoryDTO;
import com.company.billaris2.entities.InvoiceHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InvoiceHistoryMapper {

    private final UserMapper userMapper;


    public InvoiceHistoryDTO toDTO(InvoiceHistory history) {
        InvoiceHistoryDTO dto = new InvoiceHistoryDTO();
//        dto.setId(history.getId());
        dto.setActionDate(history.getActionDate());
        dto.setActionDescription(history.getActionDescription());
//        dto.setUser(userMapper.toDTO(history.getUser()));
        return dto;
    }

    public InvoiceHistory toEntity(InvoiceHistoryDTO dto) {
        InvoiceHistory history = new InvoiceHistory();
//        history.setId(dto.getId());
        history.setActionDate(dto.getActionDate());
        history.setActionDescription(dto.getActionDescription());
//        history.setUser(userMapper.toEntity(dto.getUser()));
        return history;
    }


}
