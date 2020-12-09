package playground.order.internal;

import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.onion.simplified.DomainRing;
import org.jmolecules.ddd.annotation.Factory;
import org.springframework.stereotype.Component;
import playground.order.OrderNumber;
import playground.order.Orders;

@DomainRing
@Factory
@Component
@RequiredArgsConstructor
public class OrderNumberGenerator {

    private final Orders orders;

    public OrderNumber generate() {
        return OrderNumber.of("ABC-12345");
    }

}
