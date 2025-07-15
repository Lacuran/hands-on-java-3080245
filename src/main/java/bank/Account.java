package bank;

import exeptions.AmountException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Account {
    private int id;
    private String type;
    private double balance;

    public void deposit(double amount) throws AmountException {
        if (amount < 1) {
            throw new AmountException("The minimum deposit is 1.00");
        }
        else {
            double newBalance = balance + amount;
            setBalance(newBalance);
        }
    }

    public void withdraw(double amount) {

    }
}
