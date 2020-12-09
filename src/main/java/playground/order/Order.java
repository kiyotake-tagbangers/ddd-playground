package playground.order;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;
import org.springframework.data.domain.AbstractAggregateRoot;
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
public class Order extends AbstractAggregateRoot<Order> implements AggregateRoot<Order, Order.OrderId> {

    @EmbeddedId
    @AttributeOverride(name = "orderId", column = @Column(name = "id"))
    private OrderId id;

    @Embedded
    @AttributeOverride(name = "orderNumber", column = @Column(name = "order_no"))
    private final OrderNumber orderNo;

    private final LocalDate orderDate;

    // デフォルトだと EAGER が適用され、集約をまたいで永続化してしまう
//    @ManyToOne(fetch = FetchType.LAZY)
//    private final Customer customer;

    private final Customer.CustomerAssociation customer;

    // デフォルトだと LAZY が適用、同じ集約なのでライフサイクルを同じように管理できるようにする
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderLine> lines;

    public Order(Customer.CustomerAssociation customer, OrderNumber orderNo, LocalDate orderDate, OrderLine... lines) {
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.customer = customer;
        this.lines = Arrays.asList(lines);
    }

    public Order(Customer.CustomerAssociation customer, OrderNumber orderNo, LocalDate orderDate, List<OrderLine> lines) {
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.customer = customer;
        this.lines = lines;
    }

    protected Order(){
        this.orderNo = null;
        this.orderDate = null;
        this.customer = null;
    }

    public OrderId getId() {
        return this.id;
    }

    public OrderNumber getOrderNo() {
        return this.orderNo;
    }

    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public Customer.CustomerAssociation getCustomer() {
        return this.customer;
    }

    public List<OrderLine> getLines() {
        return this.lines;
    }

    /**
     * 自身の集約が永続化される時にフックして実行される
     */
    @PrePersist
    private void init(){
        this.id = OrderId.create();
        registerEvent(new OrderCreated(this));
    }

    @Embeddable
    public static class OrderId implements Identifier, Serializable {

        private final UUID orderId;

        public OrderId(UUID id) {
            this.orderId = id;
        }

        protected OrderId(){
            this.orderId = null;
        }

        public UUID getOrderId() {
            return orderId;
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
            return orderId.getOrderId().equals(this.orderId);
        }
    }

}
