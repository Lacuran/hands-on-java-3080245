package bank;

public class Main {

    public static void main(String[] args) {

        Customer customer = DataSource.getCustomer("kbolf8z@smh.com.au");
        Account account = DataSource.getAccount(customer.getAccountId());
        System.out.println(customer.getName());
        System.out.println(account.getBalance());
    }
}
