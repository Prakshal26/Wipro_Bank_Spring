package com.wipro.bank.bank_management.controllers;

import com.wipro.bank.bank_management.models.Employee;
import com.wipro.bank.bank_management.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    private String addEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "create_employee";
    }

    @PostMapping("/")
    private String saveEmployee(@Valid Employee employee, BindingResult bindingResult,Model model) {

        if(bindingResult.hasErrors()) {
            model.addAttribute("employee",employee);
            return "create_employee";
        }
        employeeService.save(employee);
        System.out.println(employee);
        return "redirect:/displayAll";
    }

    @GetMapping("/displayAll")
    private String displayAll(Model model) {
        model.addAttribute("employees",employeeService.findAll());
        return "display";
    }

    @GetMapping("/display/{id}")
    private String displayById(@PathVariable Long id, Model model) {
        model.addAttribute("employees",employeeService.findByEmpId(id));
        return "display";
    }
}
