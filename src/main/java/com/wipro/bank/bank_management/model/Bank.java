package com.wipro.bank.bank_management.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bank {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @OneToMany(mappedBy = "bank")
    Set<Branch> branch = new HashSet<>();

    @OneToMany(mappedBy = "banks")
    Set<BankFacilities> bankFacilities = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Branch> getBranch() {
        return branch;
    }

    public void setBranch(Set<Branch> branch) {
        this.branch = branch;
    }

    public Set<BankFacilities> getBankFacilities() {
        return bankFacilities;
    }

    public void setBankFacilities(Set<BankFacilities> bankFacilities) {
        this.bankFacilities = bankFacilities;
    }
}
