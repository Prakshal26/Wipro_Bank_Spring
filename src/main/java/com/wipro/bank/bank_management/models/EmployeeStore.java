package com.wipro.bank.bank_management.models;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class EmployeeStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private Map<Long,Employee> employeeMap = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Long, Employee> getEmployeeMap() {
        return employeeMap;
    }

    public void setEmployeeMap(Map<Long, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }
}
