package ma.enset.bankaccountservice.web;

import lombok.RequiredArgsConstructor;
import ma.enset.bankaccountservice.dtos.BankAccountReq;
import ma.enset.bankaccountservice.entities.BankAccount;
import ma.enset.bankaccountservice.entities.Customer;
import ma.enset.bankaccountservice.repositories.BankAccountRepo;
import ma.enset.bankaccountservice.repositories.CustomerRepo;
import ma.enset.bankaccountservice.services.BankAccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BankAccountGraphQLController {
    private final BankAccountService bankAccountService;
    private final BankAccountRepo bankAccountRepo;
    private final CustomerRepo customerRepo;

    @QueryMapping
    public List<BankAccount> bankAccounts() {
        return bankAccountService.getAll();
    }

    @QueryMapping
    public BankAccount bankAccount(@Argument String id) {
        return bankAccountService.getOne(id);
    }

    @MutationMapping
    public BankAccount createBankAccount(@Argument BankAccountReq bankAccountInput) {
        return bankAccountService.save(bankAccountInput);
    }

    @MutationMapping
    public BankAccount updateBankAccount(@Argument String id, @Argument BankAccountReq bankAccountInput) {
        return bankAccountService.update(id, bankAccountInput);
    }

    @MutationMapping
    public void deleteBankAccount(@Argument String id) {
        bankAccountService.delete(id);
    }

    @QueryMapping
    public List<Customer> customers() {
        return customerRepo.findAll();
    }
}
