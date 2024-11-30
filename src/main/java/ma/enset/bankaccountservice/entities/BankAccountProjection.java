package ma.enset.bankaccountservice.entities;

import ma.enset.bankaccountservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "bankAccountProjection", types = BankAccount.class)
public interface BankAccountProjection {
    String getId();
    AccountType getType();
    double getBalance();
}
