package com.essam.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "_role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role extends BaseEntity{
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_sequence_generator")
    @SequenceGenerator(name = "role_sequence_generator", sequenceName = "role_sq", initialValue = 1000,
            allocationSize = 1000)
    private Integer id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Override
    public Integer getID() {
        return id;
    }
}
