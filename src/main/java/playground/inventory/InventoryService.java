package playground.inventory;

import playground.order.OrderCreated;

/**
 * @author KOGA, Yu
 */
public interface InventoryService {

    void updateStock(OrderCreated event);
}
