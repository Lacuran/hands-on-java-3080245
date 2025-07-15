package bank;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Customer {
    private final int id;
    private final String name;
    private final String username;
    private final String password;
    private final int accountId;
    private boolean authenticated;
}
