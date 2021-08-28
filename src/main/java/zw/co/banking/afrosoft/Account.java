package zw.co.banking.afrosoft;

import javax.persistence.*;

@Entity
@Table(name = "testdb")
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountNumber;
    @Column(name = "balance")
     double balance;

    public Account() {
    }

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        balance=0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String
    toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    public abstract void deposit(double amount);


    public abstract void withdraw(double amount);

}
