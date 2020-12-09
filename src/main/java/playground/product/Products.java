package playground.product;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author KOGA, Yu
 */
public interface Products extends JpaRepository<Product, Product.ProductId> {
}
