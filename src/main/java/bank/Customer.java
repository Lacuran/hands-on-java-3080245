package bank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
    private int id;
    private String name;
    private String username;
    private String password;
    private int accountId;
}
