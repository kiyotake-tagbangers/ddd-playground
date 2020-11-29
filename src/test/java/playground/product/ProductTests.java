package playground.product;

import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.types.AggregateRoot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestConstructor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author KIYOTA, Takeshi
 */
@DataJpaTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@RequiredArgsConstructor
class ProductTests {

    final TestEntityManager em;

    @Test
    void mapping() {
        var product = this.em.persistAndFlush(new Product("P-12345", "チョコモナカジャンボ"));
        assertThat(product).isInstanceOf(AggregateRoot.class);
        assertThat(product.getId()).isNotNull();
        assertThat(product.getProductNo()).isEqualTo("P-12345");
        assertThat(product.getName()).isEqualTo("チョコモナカジャンボ");
        assertThat(product.getStock()).isEqualTo(0);
    }
}