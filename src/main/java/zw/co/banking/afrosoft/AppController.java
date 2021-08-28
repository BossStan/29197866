package zw.co.banking.afrosoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    CurrentAccountService currentAccountService;
    SavingsAccountService savingsAccountService;

    @GetMapping("/")
    public Account getSavingsAccount() {
        return savingsAccountService;
    }


    @GetMapping("/open/savingsAcc/{initialDeposit}/{accountNumber}")
    public Account createCurrentAccount(@RequestParam("accountNumber") int accNumber, @RequestParam("initialDeposit") double initialDeposit) {

        if (initialDeposit > 1000) {
            LOGGER.info("Account created successfully");
            currentAccountService.deposit(initialDeposit);
            currentAccountService.setAccountNumber(accNumber);

        } else {
            LOGGER.error("Insufficient funds for opening an account");
        }
        return currentAccountService;
    }

    @GetMapping("/open/currentAcc/{initialDeposit}/{accountNumber}")
    public Account createSavingsAccount(@RequestParam("accountNumber") int accNumber, @RequestParam("initialDeposit") double initialDeposit) {

        currentAccountService.deposit(initialDeposit);
        LOGGER.error("Insufficient funds for opening an account");
        return savingsAccountService;
    }
}
