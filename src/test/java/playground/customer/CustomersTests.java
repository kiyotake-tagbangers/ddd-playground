package playground.customer;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestConstructor;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author KIYOTA, Takeshi
 */
@DataJpaTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@RequiredArgsConstructor
class CustomersTests {

    final Customers customers;

    @Test
    void findById() {
        var customer = this.customers.findById(new Customer.CustomerId(UUID.fromString("8d9b6d9b-240d-4724-a36d-2036599951ca")));
        assertThat(customer).isPresent();
    }
}