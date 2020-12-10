package playground.order.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.onion.simplified.ApplicationRing;
import org.springframework.stereotype.Service;
import playground.order.*;
import playground.product.Products;
import playground.order.OutOfStockException;

import javax.transaction.Transactional;
import java.time.LocalDate;

/**
 * @author KOGA, Yu
 */
@ApplicationRing
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final Products products;

    private final Orders orders;

    private final OrderNumberGenerator orderNumberGenerator;

    @Override
    public Order createOrder(CreateOrder command) {
        log.info("与信チェック");


        log.info("在庫チェック");
        for (OrderLine line: command.getLines()) {
            var product = products.findById(line.getProduct().getId()).orElseThrow();
            // product.hasStock() を呼ぶだけでいい
            // ドメインロジックをここで実装しない！
            if (!product.hasStock(line.getQuantity())) {
                throw new OutOfStockException("product out of stock");
            }
        }

        log.info("注文番号の採番");
        var orderNo = this.orderNumberGenerator.generate();

        log.info("注文登録");
        var order = new Order(
                command.getCustomerName(),
                orderNo,
                LocalDate.now(),
                command.getLines()
        );
        return this.orders.save(order);
    }
}
