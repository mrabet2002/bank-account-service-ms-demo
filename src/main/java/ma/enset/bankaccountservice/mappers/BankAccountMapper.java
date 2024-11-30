package ma.enset.bankaccountservice.mappers;

import ma.enset.bankaccountservice.dtos.BankAccountReq;
import ma.enset.bankaccountservice.entities.BankAccount;

import java.util.List;

public interface BankAccountMapper {
    BankAccount toBankAccount(BankAccountReq bankAccountReq);

    List<BankAccount> toBankAccounts(List<BankAccountReq> bankAccountReqs);
}
