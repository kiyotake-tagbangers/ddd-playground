package playground.product;

import playground.order.OrderCreated;

/**
 * @author KOGA, Yu
 */
public interface ProductService {

    void updateStock(OrderCreated event);
}
