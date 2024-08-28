package com.ecom.app.entity;

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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users", schema = "hubexspw")
public class User {

    @Id
    @SequenceGenerator(
            name = "user_generator",
            sequenceName = "user_sequence",
            schema = "hubexspw",
            allocationSize = 1,
            initialValue = 1001
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_generator"
    )
    private Long id;
    @Column(name = "user_name")
    private String userName;
    private String password;
    private String role;

}
