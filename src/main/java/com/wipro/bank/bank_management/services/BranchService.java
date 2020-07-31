package com.wipro.bank.bank_management.services;

import com.wipro.bank.bank_management.model.Branch;

import java.util.Set;

public interface BranchService extends CurdService<Branch,Long> {

    @Override
    Set<Branch> findAll();

    @Override
    Branch findById(Long aLong);

    @Override
    Branch save(Branch object);

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Branch object);
}
