package com.wipro.bank.bank_management.services;

import com.wipro.bank.bank_management.Repository.BranchRepository;
import com.wipro.bank.bank_management.model.Branch;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public Set<Branch> findAll() {

        Set<Branch> branch = new HashSet<>();
        branchRepository.findAll().forEach(branch::add);

        return branch;

    }

    @Override
    public Branch findById(Long aLong) {
        return branchRepository.findById(aLong).orElse(null);
    }

    @Override
    public Branch save(Branch object) {
        return branchRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        branchRepository.deleteById(aLong);

    }

    @Override
    public void delete(Branch object) {
        branchRepository.delete(object);

    }
}
