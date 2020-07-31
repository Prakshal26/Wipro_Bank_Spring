package com.wipro.bank.bank_management.Repository;

import com.wipro.bank.bank_management.model.Branch;
import org.springframework.data.repository.CrudRepository;

public interface BranchRepository extends CrudRepository<Branch,Long> {
}
