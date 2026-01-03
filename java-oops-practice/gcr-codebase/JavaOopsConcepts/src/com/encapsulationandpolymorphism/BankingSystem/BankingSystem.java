package com.encapsulationandpolymorphism.BankingSystem;
import java.util.ArrayList;
import java.util.List;

public class BankingSystem {

    public static void main(String[] args) {

        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("SA123456", "Suraj", 10000));
        accounts.add(new CurrentAccount("CA654321", "Amit", 20000));

        for (BankAccount acc : accounts) {
            System.out.println("Account Holder: " + acc.getHolderName());
            System.out.println("Account Number: " + acc.getAccountNumber());
            System.out.println("Balance: " + acc.getBalance());
            System.out.println("Interest: " + acc.calculateInterest());

          
            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                System.out.println("Loan Eligibility: " + loanAcc.calculateLoanEligibility());
            }

            System.out.println("-------------------------");
        }
    }
}
