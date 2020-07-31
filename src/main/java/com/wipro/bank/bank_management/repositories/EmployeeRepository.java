package com.wipro.bank.bank_management.repositories;

import com.wipro.bank.bank_management.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    public Employee findByEmpId(Long id);
}
