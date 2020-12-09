package playground.product;

import org.hibernate.annotations.Type;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Association;
import org.jmolecules.ddd.types.Identifier;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author KIYOTA, Takeshi
 */
@Entity
public class Product implements AggregateRoot<Product, Product.ProductId> {

    @EmbeddedId
    private ProductId id;

    private final String productNo;

    private final String name;

    private int stock;

    public Product(String productNo, String name) {
        this.productNo = productNo;
        this.name = name;
    }

    protected Product(){
        this.productNo = null;
        this.name = null;
    }

    @PrePersist
    private void Product() {
        this.id = ProductId.create();
    }

    public ProductId getId() {
        return this.id;
    }

    public String getProductNo() {
        return this.productNo;
    }

    public String getName() {
        return this.name;
    }

    public int getStock() {
        return this.stock;
    }

    @Embeddable
    public static class ProductId implements Identifier, Serializable {

        private final UUID id;

        public ProductId(UUID id) {
            this.id = id;
        }

        protected ProductId(){
            this.id = null;
        }

        public static ProductId create(){
            return new ProductId(UUID.randomUUID());
        }
    }

    public static class ProductAssociation implements Association<Product, Product.ProductId> {

        private ProductId id;

        public ProductAssociation(Product product) {
            this.id = product.getId();
        }

        @Override
        public ProductId getId() {
            return this.id;
        }
    }
}
