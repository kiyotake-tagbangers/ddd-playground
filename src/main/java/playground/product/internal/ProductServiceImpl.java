package playground.product.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.onion.simplified.ApplicationRing;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;
import playground.order.OrderCreated;
import playground.order.OrderLine;
import playground.product.ProductService;
import playground.product.Products;

import javax.transaction.Transactional;

/**
 * @author KOGA, Yu
 */
@ApplicationRing
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final Products products;

    // @TransactionalEventListener -> commit 後に実施される
    @EventListener
    @Override
    public void updateStock(OrderCreated event) {
        var order = event.getOrder();
        for (OrderLine line: order.getLines()) {
            // 更新対象の商品を取得
            var product = products.findById(line.getProduct().getId()).orElseThrow();
            // product 自身の持つ「在庫減らすメソッド」を呼び出す
            product.reduceStock(line.getQuantity());
            products.save(product);
        }
    }
}
