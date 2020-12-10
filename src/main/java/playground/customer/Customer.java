package playground.customer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Association;
import org.jmolecules.ddd.types.Identifier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author KIYOTA, Takeshi
 */
@Entity // JPAではEntityという表現しかない（AggregateもEntityも、@Entity)
public class Customer implements AggregateRoot<Customer, Customer.CustomerId> {

    @EmbeddedId
    @AttributeOverride(name = "customerId", column = @Column(name = "id"))
    private CustomerId id;

    private String name;

    public Customer(String name) {
        this.id = CustomerId.create();
        this.name = name;
    }

    protected Customer(){
    }

    @PrePersist
    private void init(){
        this.id = CustomerId.create();
    }

    public CustomerId getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    @Embeddable
    public static class CustomerId implements Identifier, Serializable {

        @JsonDeserialize
        private final UUID customerId;

        public CustomerId(UUID id) {
            this.customerId = id;
        }

        protected CustomerId(){
            this.customerId = null;
        }

        public UUID getCustomerId() {
            return this.customerId;
        }

        public static CustomerId create(){
            return new CustomerId(UUID.randomUUID());
        }
    }

    @Embeddable
    public static class CustomerAssociation implements Association<Customer, CustomerId> {

        private CustomerId id;

        protected CustomerAssociation() {
        }

        public CustomerAssociation(Customer customer) {
            this.id = customer.getId();
        }

        @Override
        public CustomerId getId() {
            return this.id;
        }
    }
}
