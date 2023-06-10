package com.mohacel.gym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String email;
    private String name;
    private Integer age;
    private String gender;
    private Double height;
    private Double weight;
}
