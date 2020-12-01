package playground.order;

import lombok.Value;
import org.jmolecules.event.types.DomainEvent;

/**
 * @author KIYOTA, Takeshi
 */
@Value
public class OrderCreated implements DomainEvent {

    private final Order order;
}
