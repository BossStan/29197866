package zw.co.banking.afrosoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SavingsAccountService extends Account{
    AccountRepository accountRepository;
    Account account;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    public SavingsAccountService() {
        super();
    }

    public SavingsAccountService(int accountNumber ) {
        super(accountNumber);
    }

    @Override
    public void deposit(double amount) {
        if(amount>0){
            LOGGER.info("amount of ZWL"+amount+" has been withdrawn");
            balance+=amount;
            account.setBalance(balance);
            saveTxn(account);

        }else{

            LOGGER.error("Can not deposit ");
        }

    }


    @Override
    public void withdraw(double amount) {
        if(amount>0){
            if(amount<=balance){
                LOGGER.info("amount of ZWL"+amount+" has been withdrawn");
                balance-=amount;
                saveTxn(account);

            }

        }else {
            LOGGER.error("cannot withdraw negative funds");

        }
    }
public Account saveTxn(Account account){
        return accountRepository.save(account);
}
}
