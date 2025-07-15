package bank;

import exeptions.AmountException;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;


    public static void main(String[] args) {
        System.out.println("Welcome to the Bank International");

        Menu menu = new Menu();
        menu.scanner = new Scanner(System.in);

        Customer customer = menu.authenticateUser();
        if (customer != null) {
            Account account = DataSource.getAccount(customer.getAccountId());
            menu.showMenu(customer, account);
        }


        menu.scanner.close();
    }

    private Customer authenticateUser() {
        System.out.println("Please enter Username");
        String username = scanner.next();

        System.out.println("Enter Password");
        String password = scanner.next();

        Customer customer = null;

        try {
            customer = Authenticator.login(username, password);
        } catch (LoginException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return customer;
    }

    private void showMenu(Customer customer, Account account) {

        int selection = 0;

        while (selection != 4 && customer.isAuthenticated()) {
            System.out.println("======================================================================");
            System.out.println("PLease selection one of the following options");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("======================================================================");

            selection = scanner.nextInt();
            double amount = 0.0;

            switch (selection) {
                case 1 -> {
                    System.out.println("How much you want do deposit?");
                    amount = scanner.nextDouble();

                    try {
                        account.deposit(amount);
                    } catch (AmountException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Please try again.");
                    }
                }
                case 2 -> {
                    System.out.println("How much you want to withdraw?");
                    amount = scanner.nextDouble();
                    account.withdraw(amount);
                }
                case 3 -> {
                    System.out.println("Current balance: " + account.getBalance());
                }
                case 4 -> {
                    Authenticator.logout(customer);
                    System.out.println("Thanks for using International Banking System");
                }
                default -> {
                    System.out.println("Invalid option try again");
                }
            }
        }
    }
}


