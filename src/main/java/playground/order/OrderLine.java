package playground.order;

import org.javamoney.moneta.Money;
import org.jmolecules.ddd.types.Identifier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author KIYOTA, Takeshi
 */
@Entity
public class OrderLine implements org.jmolecules.ddd.types.Entity<Order, OrderLine.OrderLineId>{

    @EmbeddedId
    private OrderLineId id;

    private final String name;

    private final Money price;

    private final int quantity;

    public OrderLine(String name, Money price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    protected OrderLine(){
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

    @Embeddable
    public static class OrderLineId implements Identifier, Serializable {
        private final UUID id;

        public OrderLineId(UUID id) {
            this.id = id;
        }

        protected OrderLineId(){
            this.id = null;
        }

        public static OrderLineId create(){
            return new OrderLineId(UUID.randomUUID());
        }
    }
}
