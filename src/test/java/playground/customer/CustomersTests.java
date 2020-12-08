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
        var customer = this.customers.findById(new Customer.CustomerId(UUID.fromString("2fdb63e4-ee55-4740-9401-c6bff79cec45")));
        assertThat(customer).isPresent();
    }
}