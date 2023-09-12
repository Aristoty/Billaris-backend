package com.company.billaris2.models;

import com.company.billaris2.entities.Address;
import com.company.billaris2.entities.Company;
import com.company.billaris2.entities.Token;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;

    private Integer id;

    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private String about;
    private Role role;
    private Set<Company> companies = new HashSet<>();
    private Address address;
    private Timestamp createAt;
    private Timestamp updateAt;
}
