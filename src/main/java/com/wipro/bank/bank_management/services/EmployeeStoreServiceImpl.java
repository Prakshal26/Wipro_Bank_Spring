package com.wipro.bank.bank_management.services;

import com.wipro.bank.bank_management.models.EmployeeStore;
import com.wipro.bank.bank_management.repositories.EmployeeStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeStoreServiceImpl implements EmployeeStoreService {

    private final EmployeeStoreRepository employeeStoreRepository;

    @Autowired
    public EmployeeStoreServiceImpl(EmployeeStoreRepository employeeStoreRepository) {
        this.employeeStoreRepository = employeeStoreRepository;
    }

    @Override
    public Set<EmployeeStore> findAll() {
        Set<EmployeeStore> employeeStores = new HashSet<>();
        employeeStoreRepository.findAll().forEach(employeeStores::add);
        return employeeStores;
    }

    @Override
    public EmployeeStore findById(Long aLong) {
        return employeeStoreRepository.findById(aLong).orElse(null);
    }

    @Override
    public EmployeeStore save(EmployeeStore object) {
        return employeeStoreRepository.save(object);
    }

    @Override
    public void delete(EmployeeStore object) {
            employeeStoreRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        employeeStoreRepository.deleteById(aLong);

    }

}