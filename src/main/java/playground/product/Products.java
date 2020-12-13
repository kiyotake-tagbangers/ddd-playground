package playground.product;

import org.jmolecules.architecture.onion.simplified.DomainRing;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author KOGA, Yu
 */
@DomainRing
public interface Products extends JpaRepository<Product, Product.ProductId> {
}
