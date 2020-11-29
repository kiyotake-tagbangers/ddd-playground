package playground.customer;

import lombok.RequiredArgsConstructor;
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
class CustomerTests {

    final TestEntityManager em;

    @Test
    void mapping(){
        var customer = this.em.persistAndFlush(new Customer("空承太郎"));
        assertThat(customer.getId()).isNotNull();
        assertThat(customer.getName()).isEqualTo("空承太郎");
    }

}