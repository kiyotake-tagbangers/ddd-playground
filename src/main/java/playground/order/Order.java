package playground.order;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;
import playground.customer.Customer;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author KIYOTA, Takeshi
 */
@Entity
public class Order implements AggregateRoot<Order, Order.OrderId> {

    @EmbeddedId
    private OrderId id;

    private final String orderNo;
    private final LocalDate orderDate;

    @ManyToOne
    private final Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLine> lines;

    public Order(String orderNo, LocalDate orderDate, Customer customer, OrderLine... lines) {
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.customer = customer;
        this.lines = Arrays.asList(lines);
    }

    protected Order(){
        this.orderNo = null;
        this.orderDate = null;
        this.customer = null;
    }

    public OrderId getId() {
        return this.id;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public List<OrderLine> getLines() {
        return this.lines;
    }

    @PrePersist
    private void init(){
        this.id = OrderId.create();
    }

    @Embeddable
    public static class OrderId implements Identifier, Serializable {

        private final UUID id;

        public OrderId(UUID id) {
            this.id = id;
        }

        protected OrderId(){
            this.id = null;
        }

        public UUID getId() {
            return id;
        }

        public static OrderId create(){
            return new OrderId(UUID.randomUUID());
        }

        @Override
        public boolean equals(Object other) {
            if (other == this){
                return true;
            }
            if (!(other instanceof OrderId)){
                return false;
            }
            OrderId orderId = (OrderId) other;
            return orderId.getId().equals(this.id);
        }
    }

}
