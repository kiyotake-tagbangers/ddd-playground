package playground.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author KIYOTA, Takeshi
 */
public interface Orders extends JpaRepository<Order, Order.OrderId> {
}
