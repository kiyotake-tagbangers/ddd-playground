package playground.order;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.javamoney.moneta.Money;
import org.jmolecules.ddd.types.Identifier;
import playground.product.Product;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author KIYOTA, Takeshi
 */
@Entity
public class OrderLine implements org.jmolecules.ddd.types.Entity<Order, OrderLine.OrderLineId>{

    @EmbeddedId
    @AttributeOverride(name = "orderLineId", column = @Column(name = "id"))
    private OrderLineId id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    private final String name;

    private final Money price;

    private final int quantity;

    public OrderLine(Product product,String name, Money price, int quantity) {
        this.product =  product;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    protected OrderLine(){
        this.product = null;
        this.name = null;
        this.price = null;
        this.quantity = 0;
    }

    @PrePersist
    public void init(){
        this.id = OrderLineId.create();
    }

    @Override
    public OrderLineId getId() {
        return this.id;
    }

    public String getPrice(){
        return this.name;
    }

    public Money getMoney(){
        return this.price;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public Product getProduct() {
        return product;
    }

    public String getName() {
        return name;
    }

    @Embeddable
    public static class OrderLineId implements Identifier, Serializable {

        @JsonDeserialize
        private final UUID orderLineId;

        public OrderLineId(UUID id) {
            this.orderLineId = id;
        }

        protected OrderLineId(){
            this.orderLineId = null;
        }

        public static OrderLineId create(){
            return new OrderLineId(UUID.randomUUID());
        }
    }
}
