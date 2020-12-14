package playground.inventory;

import org.jmolecules.architecture.onion.simplified.ApplicationRing;
import playground.order.OrderCreated;

/**
 * @author KOGA, Yu
 */
@ApplicationRing
public interface InventoryService {

    void updateStock(OrderCreated event);
}
