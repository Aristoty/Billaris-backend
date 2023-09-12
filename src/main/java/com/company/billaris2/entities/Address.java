package com.company.billaris2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String zipCode;
    private String city;
    private String country;

//    @OneToOne(mappedBy = "address")
//    private Company company;
//
//    @OneToOne(mappedBy = "address")
//    private Client client;
//
//    @OneToOne(mappedBy = "address")
//    private Invoice invoice;


}
