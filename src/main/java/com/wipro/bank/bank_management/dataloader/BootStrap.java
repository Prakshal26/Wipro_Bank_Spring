package com.wipro.bank.bank_management.dataloader;

import com.wipro.bank.bank_management.model.Bank;
import com.wipro.bank.bank_management.model.BankFacilities;
import com.wipro.bank.bank_management.model.Branch;
import com.wipro.bank.bank_management.services.BankFacilitiesService;
import com.wipro.bank.bank_management.services.BankService;
import com.wipro.bank.bank_management.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {

    private final BranchService branchService;
    private final BankService bankService;
    private final BankFacilitiesService bankFacilitiesService;

    public BootStrap(BranchService branchService, BankService bankService, BankFacilitiesService bankFacilitiesService) {
        this.branchService = branchService;
        this.bankService = bankService;
        this.bankFacilitiesService = bankFacilitiesService;
    }

    @Override
    public void run(String... args) throws Exception {

        Bank bank1 = new Bank();
        bank1.setName("HDFC Bank");
        bank1.setAddress("Electronic City Bangalore");


        Branch branch1 = new Branch();
        branch1.setBranchName("HDFC-1");
        branch1.setIfsc("HDFC10001");
        branch1.setBank(bank1);
        //branchService.save(branch1);

        Branch branch2 = new Branch();
        branch2.setBranchName("HDFC-2");
        branch2.setIfsc("HDFC10002");
        branch2.setBank(bank1);
        //branchService.save(branch2);

        Branch branch3 = new Branch();
        branch3.setBranchName("HDFC-3");
        branch3.setIfsc("HDFC10003");
        branch3.setBank(bank1);
        //branchService.save(branch3);

        Branch branch4 = new Branch();
        branch4.setBranchName("HDFC-4");
        branch4.setIfsc("HDFC10004");
        branch4.setBank(bank1);
        //branchService.save(branch4);

        Branch branch5 = new Branch();
        branch5.setBranchName("HDFC-5");
        branch5.setIfsc("HDFC10005");
        branch5.setBank(bank1);
        //branchService.save(branch5);

        Branch branch6 = new Branch();
        branch6.setBranchName("HDFC-6");
        branch6.setIfsc("HDFC10006");
        branch6.setBank(bank1);
        //branchService.save(branch6);

        Branch branch7 = new Branch();
        branch7.setBranchName("HDFC-7");
        branch7.setIfsc("HDFC10007");
        branch7.setBank(bank1);
        //branchService.save(branch7);

        Branch branch8 = new Branch();
        branch8.setBranchName("HDFC-8");
        branch8.setIfsc("HDFC10008");
        branch8.setBank(bank1);
        //branchService.save(branch8);

        Branch branch9 = new Branch();
        branch9.setBranchName("HDFC-9");
        branch9.setIfsc("HDFC10009");
        branch9.setBank(bank1);
        //branchService.save(branch9);





        Branch branch10 = new Branch();
        branch10.setBranchName("HDFC-10");
        branch10.setIfsc("HDFC100010");
        branch10.setBank(bank1);




        bank1.getBranch().add(branch1);
        bank1.getBranch().add(branch2);
        bank1.getBranch().add(branch3);
        bank1.getBranch().add(branch4);
        bank1.getBranch().add(branch5);
        bank1.getBranch().add(branch6);
        bank1.getBranch().add(branch7);
        bank1.getBranch().add(branch8);
        bank1.getBranch().add(branch9);
        bank1.getBranch().add(branch10);


        BankFacilities bankFacilities1 = new BankFacilities();
        bankFacilities1.setServiceName("Open A RD account");
        bankFacilities1.setBank(bank1);

        BankFacilities bankFacilities2 = new BankFacilities();
        bankFacilities2.setServiceName("Get Education Loan");
        bankFacilities2.setBank(bank1);

        BankFacilities bankFacilities3 = new BankFacilities();
        bankFacilities3.setServiceName("Print Passbook");
        bankFacilities3.setBank(bank1);

        BankFacilities bankFacilities4 = new BankFacilities();
        bankFacilities4.setServiceName("Activate Net Banking");
        bankFacilities4.setBank(bank1);


        bank1.getBankFacilities().add(bankFacilities1);
        bank1.getBankFacilities().add(bankFacilities2);
        bank1.getBankFacilities().add(bankFacilities3);
        bank1.getBankFacilities().add(bankFacilities4);

        bankService.save(bank1);


        branchService.save(branch1);
        branchService.save(branch2);
        branchService.save(branch3);
        branchService.save(branch4);
        branchService.save(branch5);
        branchService.save(branch6);
        branchService.save(branch7);
        branchService.save(branch8);
       branchService.save(branch9);
        branchService.save(branch10);


        bankFacilitiesService.save(bankFacilities1);
        bankFacilitiesService.save(bankFacilities2);
        bankFacilitiesService.save(bankFacilities3);
        bankFacilitiesService.save(bankFacilities4);

    }
}
