package com.wipro.bank.bank_management.services;

import com.wipro.bank.bank_management.Repository.BankFacilitiesRepository;
import com.wipro.bank.bank_management.model.BankFacilities;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BankFacilitiesServiceImpl implements BankFacilitiesService {

    private final BankFacilitiesRepository bankFacilitiesRepository;

    public BankFacilitiesServiceImpl(BankFacilitiesRepository bankFacilitiesRepository) {
        this.bankFacilitiesRepository = bankFacilitiesRepository;
    }

    @Override
    public Set<BankFacilities> findAll() {
        Set<BankFacilities> bankFacilitiesSet = new HashSet<>();
        bankFacilitiesRepository.findAll().forEach(bankFacilitiesSet::add);
        return bankFacilitiesSet;
    }

    @Override
    public BankFacilities findById(Long aLong) {
        return bankFacilitiesRepository.findById(aLong).orElse(null);
    }

    @Override
    public BankFacilities save(BankFacilities object) {
        return bankFacilitiesRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        bankFacilitiesRepository.deleteById(aLong);

    }

    @Override
    public void delete(BankFacilities object) {
        bankFacilitiesRepository.delete(object);
    }
}
