package playground.order;

import lombok.RequiredArgsConstructor;
import org.javamoney.moneta.Money;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Entity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestConstructor;
import playground.customer.Customer;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author KIYOTA, Takeshi
 */
@DataJpaTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@RequiredArgsConstructor
class OrderTests {

    final TestEntityManager em;

    @Test
    void mapping() {
        var customer = this.em.persistAndFlush(new Customer("空条承太郎"));
        var order = this.em.persistAndFlush(new Order
                ("O-12345",
                        LocalDate.of(2020, 11, 28),
                        customer,
                        new OrderLine("チョコモナカジャンボ", Money.of(140,"JPY"),1),
                        new OrderLine("バニラモナカジャンボ", Money.of(140,"JPY"),1),
                        new OrderLine("小豆バー", Money.of(100,"JPY"),3)));
        assertThat(order).isInstanceOf(AggregateRoot.class);
        assertThat(order.getLines().get(0)).isInstanceOf(Entity.class);
        assertThat(order.getId()).isNotNull();
        assertThat(order.getOrderNo()).isEqualTo("O-12345");
        assertThat(order.getOrderDate()).isEqualTo(LocalDate.of(2020, 11, 28));
        assertThat(order.getCustomer().getName()).isEqualTo("空条承太郎");
        assertThat(order.getLines()).hasSize(3);
    }
}