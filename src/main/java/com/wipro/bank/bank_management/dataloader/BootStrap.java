package com.wipro.bank.bank_management.dataloader;

import com.wipro.bank.bank_management.models.Employee;
import com.wipro.bank.bank_management.models.EmployeeStore;

import com.wipro.bank.bank_management.services.EmployeeStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {

    private  EmployeeStoreService employeeStoreService;

    @Autowired
    public BootStrap(EmployeeStoreService employeeStoreService) {
        this.employeeStoreService = employeeStoreService;
    }


    @Override
    public void run(String... args) throws Exception {

        EmployeeStore employeeStore = new EmployeeStore();


        Employee employee = new Employee();
        employee.setEmpId(1000L);
        employee.setEmail("jprak@gmal.com");
        employee.setLocation("Dehradun");
        employee.setName("Prakshal");

        Employee employee1 = new Employee();
        employee1.setName("Swasti");
        employee1.setLocation("Delhi");
        employee1.setEmail("jswasti22@gmail.com");
        employee1.setEmpId(2000L);

        employeeStore.getEmployeeMap().put(employee.getEmpId(),employee);
        employeeStore.getEmployeeMap().put(employee1.getEmpId(),employee1);

        employeeStoreService.save(employeeStore);

    }
}
