package zw.co.banking.afrosoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrentAccountService extends Account{
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    public CurrentAccountService() {
        super();
    }

    public CurrentAccountService(int accountNumber ) {
        super(accountNumber);
    }

    @Override
    public void deposit(double amount) {
        if(amount>0){
            LOGGER.info("amount of ZWL"+amount+" has been withdrawn");
            balance+=amount;

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
            }

        }else {
            LOGGER.error("cannot withdraw negative funds");

        }
    }
}
