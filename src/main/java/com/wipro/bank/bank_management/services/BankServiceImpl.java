package com.wipro.bank.bank_management.services;

import com.wipro.bank.bank_management.Repository.BankRepository;
import com.wipro.bank.bank_management.model.Bank;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BankServiceImpl implements BankService{

    private final BankRepository bankRepository;

    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public Set<Bank> findAll() {

        Set<Bank> banks = new HashSet<>();
        bankRepository.findAll().forEach(banks::add);

        return banks;

    }

    @Override
    public Bank findById(Long aLong) {
        return bankRepository.findById(aLong).orElse(null);
    }

    @Override
    public Bank save(Bank object) {
        return bankRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        bankRepository.deleteById(aLong);

    }
    @Override
    public void delete(Bank object) {
        bankRepository.delete(object);
    }
}
