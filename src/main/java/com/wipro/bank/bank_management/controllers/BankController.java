package com.wipro.bank.bank_management.controllers;

import com.wipro.bank.bank_management.model.Bank;
import com.wipro.bank.bank_management.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/name")
    List<String> name(){

       Set<Bank>bankSet = bankService.findAll();
       ArrayList<String> name = new ArrayList<>();
       bankSet.forEach(bank -> name.add(bank.getName()));

        return name;
    }

    @GetMapping("/address")
    List<String> address(){

        Set<Bank>bankSet = bankService.findAll();
        ArrayList<String> address = new ArrayList<>();
        bankSet.forEach(bank -> address.add(bank.getAddress()));

        return address;
    }


}
