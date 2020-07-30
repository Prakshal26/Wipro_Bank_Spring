package com.wipro.bank.bank_management.Repository;
import com.wipro.bank.bank_management.model.Bank;
import org.springframework.data.repository.CrudRepository;


public interface BankRepository extends CrudRepository<Bank,Long> {
}
