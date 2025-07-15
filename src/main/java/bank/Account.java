package bank;

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

    public void deposit(double amount) {

    }

    public void withdraw(double amount) {

    }
}
