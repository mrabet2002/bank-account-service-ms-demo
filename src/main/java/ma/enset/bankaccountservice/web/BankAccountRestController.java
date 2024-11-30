package ma.enset.bankaccountservice.web;

import lombok.RequiredArgsConstructor;
import ma.enset.bankaccountservice.dtos.BankAccountReq;
import ma.enset.bankaccountservice.entities.BankAccount;
import ma.enset.bankaccountservice.repositories.BankAccountRepo;
import ma.enset.bankaccountservice.services.BankAccountService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/bank-accounts")
@RequiredArgsConstructor
public class BankAccountRestController {
    private final BankAccountService bankAccountService;


    @GetMapping
    public List<BankAccount> getBankAccounts() {
        return bankAccountService.getAll();
    }

    @GetMapping("/{id}")
    public BankAccount getBankAccount(@PathVariable String id) {
        return bankAccountService.getOne(id);
    }

    @PostMapping
    public BankAccount saveBankAccount(@RequestBody BankAccountReq bankAccount) {
        return bankAccountService.save(bankAccount);
    }

    @PutMapping("/{id}")
    public BankAccount updateBankAccount(
            @PathVariable String id,
            @RequestBody BankAccountReq bankAccount
    ) {
        return bankAccountService.update(id, bankAccount);
    }

    @DeleteMapping("/{id}")
    public void deleteBankAccount(@PathVariable String id) {
        bankAccountService.delete(id);
    }
}
