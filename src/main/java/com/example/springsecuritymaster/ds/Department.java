package com.example.springsecuritymaster.ds;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @NotBlank(message = "Code cannot contain be empty!")
    @Pattern(regexp = "[A-Za-z]*",message = "Code cannot contain illegal characters")
    private String code;
    @NotBlank(message = "Name cannot contain be empty!")
    @Pattern(regexp = "[A-Za-z]*",message = "Name cannot contain illegal characters")
    private  String name;
    @NotBlank(message = "Country cannot be empty")
    @Pattern(regexp = "[A-Za-z]*",message = "Country cannot contain illegal characters ")
    private  String country;

    public Department() {
    }

    public Department(String code, String name, String country) {
        this.code = code;
        this.name = name;
        this.country = country;
    }
}
