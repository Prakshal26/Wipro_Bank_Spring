package com.wipro.bank.bank_management.controllers;

import com.wipro.bank.bank_management.models.Employee;
import com.wipro.bank.bank_management.models.EmployeeStore;
import com.wipro.bank.bank_management.services.EmployeeStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
public class EmployeeController {


   private final EmployeeStoreService employeeStoreService;

   @Autowired
    public EmployeeController(EmployeeStoreService employeeStoreService) {
        this.employeeStoreService = employeeStoreService;
    }

    @GetMapping("/")
    private Set<EmployeeStore> employeeStoreMap() {

       return employeeStoreService.findAll();

    }

    @PostMapping("/")
    private void storeEmployee(@RequestBody Employee employee) {

       Set<EmployeeStore> employeeStores = employeeStoreService.findAll();

       if(employeeStores.isEmpty()) {
           EmployeeStore employeeStore = new EmployeeStore();
           employeeStore.getEmployeeMap().put(employee.getEmpId(),employee);
       }
        for(EmployeeStore e: employeeStores) {
            e.getEmployeeMap().put(employee.getEmpId(),employee);
            employeeStoreService.save(e);
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteEmployee(@PathVariable Long id) {

        Set<EmployeeStore> employeeStores = employeeStoreService.findAll();

        if(employeeStores.isEmpty()) {
            return new ResponseEntity<>("Employee Does not Exist", HttpStatus.BAD_REQUEST);
        }

        for(EmployeeStore e: employeeStores) {

            if(!e.getEmployeeMap().containsKey(id))
                return new ResponseEntity<>("Employee Does not Exist", HttpStatus.BAD_REQUEST);

            e.getEmployeeMap().remove(id);
            employeeStoreService.save(e);
        }

        return new ResponseEntity<>("Employee Deleted Successfully", HttpStatus.ACCEPTED);

    }

    @PutMapping("/{id}")
    private ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {

        Set<EmployeeStore> employeeStores = employeeStoreService.findAll();


        if(employeeStores.isEmpty()) {
            return new ResponseEntity<>("Employee Does not Exist", HttpStatus.BAD_REQUEST);
        }


        for(EmployeeStore e: employeeStores) {

            if(!e.getEmployeeMap().containsKey(id))
                return new ResponseEntity<>("Employee Does not Exist", HttpStatus.BAD_REQUEST);

            e.getEmployeeMap().remove(id);
            e.getEmployeeMap().put(employee.getEmpId(),employee);
            employeeStoreService.save(e);
        }
        return new ResponseEntity<>("Employee Updated Successfully", HttpStatus.ACCEPTED);
    }
}
