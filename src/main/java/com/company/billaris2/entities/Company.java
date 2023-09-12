package com.company.billaris2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String logo;
    private String description;

    // Clé étrangère vers l'utilisateur qui a créé l'entreprise
//    @OneToMany
//    @JoinColumn(name = "user_id")
//    private User user;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "companies")
    private List<User> users;

    // Champ pour l'administrateur principal
    private Integer adminId;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
