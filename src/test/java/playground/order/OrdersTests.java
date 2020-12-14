package playground.order;

import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.types.AggregateRoot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestConstructor;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author KIYOTA, Takeshi
 */
@DataJpaTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@RequiredArgsConstructor
class OrdersTests {

    final Orders orders;

    private final TestEntityManager em;

    @Test
    void aggregateViolation() {
        // 注文集約を取得
        var order = this.orders.findById(new Order.OrderId(UUID.fromString("bbb6f2f3-104b-489c-8048-ac08318a4898"))).orElseThrow();

        assertThat(order.getLines()).extracting("product.name")
                .contains("チョコモナカジャンボ","バニラモナカジャンボ","小豆バー");
    }
}