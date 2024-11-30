package ma.enset.bankaccountservice.mappers;

import ma.enset.bankaccountservice.dtos.BankAccountReq;
import ma.enset.bankaccountservice.entities.BankAccount;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankAccountMapperImpl implements BankAccountMapper{
    @Override
    public BankAccount toBankAccount(BankAccountReq bankAccountReq) {
        return BankAccount
                .builder()
                .id(null)
                .balance(bankAccountReq.getBalance())
                .currency(bankAccountReq.getCurrency())
                .type(bankAccountReq.getType())
                .createdAt(null)
                .build();
    }

    @Override
    public List<BankAccount> toBankAccounts(List<BankAccountReq> bankAccountReqs) {
        return bankAccountReqs.stream().map(this::toBankAccount).toList();
    }
}
