import com.banking.app.Account;
import com.banking.app.Address;
import com.banking.app.Customer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountTest {

    @Test
    void shouldUpdateAllAccountsAddressesWhenCustomerAddressIsUpdated() {
        Account account1 = new Account("ACC1", new Address("Bangalore"));
        Account account2 = new Account("ACC2", new Address("Bangalore"));
        Customer customer = new Customer("2131", "Mr Ram", new Address("Bangalore"), List.of(account1, account2));

        customer.updateAddress(new Address("Hyderabad"));
        assertThat(account1.getAddress().getCity()).isEqualTo("Hyderabad");
        assertThat(account2.getAddress().getCity()).isEqualTo("Hyderabad");
    }
}
