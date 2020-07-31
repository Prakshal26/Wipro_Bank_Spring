package com.wipro.bank.bank_management.model;

import javax.persistence.*;

@Entity
public class BankFacilities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;

    @ManyToOne
    private Bank banks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Bank getBank() {
        return banks;
    }

    public void setBank(Bank banks) {
        this.banks = banks;
    }
}
