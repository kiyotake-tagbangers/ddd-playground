package playground.order;

import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.types.AggregateRoot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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

    @Test
    void findById() {
        var order = this.orders.findById(new Order.OrderId(UUID.fromString("bbb6f2f3-104b-489c-8048-ac08318a4898")))
                .orElseThrow();
        assertThat(order.getId()).isEqualTo(new Order.OrderId(UUID.fromString("bbb6f2f3-104b-489c-8048-ac08318a4898")));
        assertThat(order.getLines()).hasSize(3);
    }
}