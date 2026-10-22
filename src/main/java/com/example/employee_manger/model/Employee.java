package com.example.employee_manger.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "employees")
@Getter 
@Setter 
@NoArgsConstructor 


public class Employee {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    // Explicit setter keeps the ID update available even if the IDE has not
    // enabled Lombok annotation processing.
    public void setId(Long id) {
        this.id = id;
    }

    @NotBlank (message = "Full name is required")
    private String fullName;

    @Positive (message = "Salary must be a positive number")
    private Double salary;

    @Column (unique = true)
    @NotBlank (message = "Email is required")
    @Email (message = "Email should be valid")
    private String email;

    @Pattern (regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;
}
