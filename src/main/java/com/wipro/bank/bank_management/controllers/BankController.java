package com.wipro.bank.bank_management.controllers;

import com.wipro.bank.bank_management.model.Bank;
import com.wipro.bank.bank_management.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/name")
    @ResponseBody
    List<String> name(){

       Set<Bank>bankSet = bankService.findAll();
       ArrayList<String> name = new ArrayList<>();
       bankSet.forEach(bank -> name.add(bank.getName()));

        return name;
    }

    @GetMapping("/address")
    @ResponseBody
    List<String> address(){

        Set<Bank>bankSet = bankService.findAll();
        ArrayList<String> address = new ArrayList<>();
        bankSet.forEach(bank -> address.add(bank.getAddress()));

        return address;
    }

    @GetMapping("/branches")
    public String bankNames(Model model) {
        model.addAttribute("bank",bankService.findById(1L));
        return "/bank/bank_list";
    }

    @GetMapping("/services")
    public String bankServices(Model model) {
        model.addAttribute("bank",bankService.findById(1L));
        return "/bank/bank_services";
    }

}
