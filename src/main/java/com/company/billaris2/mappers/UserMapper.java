package com.company.billaris2.mappers;

import com.company.billaris2.DTO.UserDTO;
import com.company.billaris2.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final CompanyMapper companyMapper;

    public UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
//        dto.setId(user.getId());
        dto.setFirstname(user.getFirstname());
        dto.setLastname(user.getLastname());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setAbout(user.getAbout());
        dto.setRole(user.getRole());
//        dto.setTokens(TokenMapper.INSTANCE.toDTOList(user.getTokens()));
//        dto.setCompany(companyMapper.toDTO(user.getCompany()));
        return dto;
    }

    public User toEntity(UserDTO dto) {
        User user = new User();
//        user.setId(dto.getId());
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setAbout(dto.getAbout());
        user.setRole(dto.getRole());
//        user.setTokens(TokenMapper.INSTANCE.toEntityList(dto.getTokens()));
//        user.setCompany(companyMapper.toEntity(dto.getCompany()));
        return user;
    }
}
