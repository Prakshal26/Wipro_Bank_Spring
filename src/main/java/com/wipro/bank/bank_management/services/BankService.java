package com.wipro.bank.bank_management.services;


import com.wipro.bank.bank_management.model.Bank;

import java.util.Set;

public interface BankService extends CurdService<Bank,Long> {

    @Override
    Set<Bank> findAll();

    @Override
    Bank findById(Long aLong);

    @Override
    Bank save(Bank object);

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Bank object);
}
