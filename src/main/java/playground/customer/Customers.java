package playground.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author KIYOTA, Takeshi
 */
public interface Customers extends JpaRepository<Customer, Customer.CustomerId> {
}
