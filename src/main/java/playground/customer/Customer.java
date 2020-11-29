package playground.customer;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author KIYOTA, Takeshi
 */
@Entity
public class Customer implements AggregateRoot<Customer, Customer.CustomerId> {

    @EmbeddedId
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

        private final UUID id;

        public CustomerId(UUID id) {
            this.id = id;
        }

        protected CustomerId(){
            this.id = null;
        }

        public UUID getId() {
            return this.id;
        }

        public static CustomerId create(){
            return new CustomerId(UUID.randomUUID());
        }
    }
}
