package ma.enset.bankaccountservice;

import ma.enset.bankaccountservice.entities.BankAccount;
import ma.enset.bankaccountservice.entities.Customer;
import ma.enset.bankaccountservice.enums.AccountType;
import ma.enset.bankaccountservice.repositories.BankAccountRepo;
import ma.enset.bankaccountservice.repositories.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            BankAccountRepo bankAccountRepo,
            CustomerRepo customerRepo
    ) {
        return args -> {
//            Generating a list of customers
            List.of("Amine", "Yassine", "Omar", "Hassan", "Khalid").forEach(
                    name -> {
                        Customer customer = Customer.builder()
                                .name(name)
                                .build();
                        customer = customerRepo.save(customer);
                        for (int i = 0; i < 10; i++) {
                            bankAccountRepo.save(
                                    BankAccount.builder()
                                            .id("BA" + i)
                                            .balance(Math.random() * 10000)
                                            .createdAt(LocalDateTime.now())
                                            .currency("MAD")
                                            .type(i % 2 == 0 ? AccountType.CURRENT : AccountType.SAVINGS)
                                            .customer(customer)
                                            .build()
                            );
                        }
                    }
            );


        };
    }

}
