package com.company.billaris2.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CompanyDTO {

    private String name;
    private String email;
    private String phoneNumber;
    private String logo;
    private String description;
    private List<Integer> userIds; // ID de l'utilisateur qui a créé l'entreprise
    private AddressDTO address;
    private Integer AdminId; // ID de l'administrateur principal
}
