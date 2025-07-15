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
            DataSource.updateAccountBalance(id, newBalance);
        }
    }

    public void withdraw(double amount) throws AmountException {
        if (amount < 0) {
            throw new AmountException("The amount of withdraw must be greater than 0.");
        }
        else if (amount > getBalance()){
            throw new AmountException("Insufficient founds");
        } else {
            double newBalance = balance - amount;
            setBalance(newBalance);
            DataSource.updateAccountBalance(id, newBalance);
        }
    }
}
