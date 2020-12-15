package playground.order;

import org.jmolecules.architecture.onion.simplified.DomainRing;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author KIYOTA, Takeshi
 */
@DomainRing
public interface Orders extends JpaRepository<Order, Order.OrderId> {
}
