package com.example.employee_manger.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee_manger.model.Employee;
import java.util.List;


public interface  EmployeeRepository extends JpaRepository<Employee, Long> {
    
    Optional<Employee> findEmployeeById(Long id);

    List<Employee> findByFullName(String fullName);

    public List<Employee> findByFullNameContainingIgnoreCase(String fullName);

    

}
