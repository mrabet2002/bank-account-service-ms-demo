package ma.enset.bankaccountservice.services;

import lombok.RequiredArgsConstructor;
import ma.enset.bankaccountservice.dtos.BankAccountReq;
import ma.enset.bankaccountservice.entities.BankAccount;
import ma.enset.bankaccountservice.mappers.BankAccountMapper;
import ma.enset.bankaccountservice.repositories.BankAccountRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService{
    private final BankAccountRepo bankAccountRepo;
    private final BankAccountMapper bankAccountMapper;
    @Override
    public List<BankAccount> getAll() {
        return bankAccountRepo.findAll();
    }

    @Override
    public BankAccount getOne(String id) {
        return bankAccountRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Bank account not found")
        );
    }

    @Override
    public BankAccount save(BankAccountReq bankAccountReq) {
        BankAccount bankAccount = bankAccountMapper.toBankAccount(bankAccountReq);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setBalance(0);
        bankAccount.setCreatedAt(LocalDateTime.now());
        return bankAccountRepo.save(bankAccount);
    }

    @Override
    public BankAccount update(String id, BankAccountReq bankAccountReq) {
        if (!bankAccountRepo.existsById(id)) {
            throw new RuntimeException("Bank account not found");
        }
        BankAccount bankAccount = bankAccountMapper.toBankAccount(bankAccountReq);
        bankAccount.setId(id);
        return bankAccountRepo.save(bankAccount);
    }

    @Override
    public void delete(String id) {
        bankAccountRepo.deleteById(id);
    }
}
