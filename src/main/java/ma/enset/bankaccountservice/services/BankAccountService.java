package ma.enset.bankaccountservice.services;

import ma.enset.bankaccountservice.dtos.BankAccountReq;
import ma.enset.bankaccountservice.entities.BankAccount;

import java.util.List;

public interface BankAccountService {
    List<BankAccount> getAll();
    BankAccount getOne(String id);
    BankAccount save(BankAccountReq bankAccountReq);
    BankAccount update(String id, BankAccountReq bankAccountReq);
    void delete(String id);
}
