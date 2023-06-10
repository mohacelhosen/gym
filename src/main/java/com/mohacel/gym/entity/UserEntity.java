package com.mohacel.gym.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String name;
    private Integer age;
    private String gender;
    private Double height;
    private Double weight;
    @Column(updatable = false,insertable = true)
    @CreatedDate
    private LocalDate createdDate;
    @Column(updatable = true,insertable = false)
    private  LocalDate updatedDate;

    private String password;
}
