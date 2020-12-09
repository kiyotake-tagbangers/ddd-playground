package playground.order.web;

import lombok.RequiredArgsConstructor;
import org.assertj.core.util.Files;
import org.javamoney.moneta.Money;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;
import playground.customer.Customer;
import playground.order.*;
import playground.product.Product;

import java.io.File;
import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author KOGA, Yu
 */
@SpringBootTest
@AutoConfigureMockMvc
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@RequiredArgsConstructor
public class OrderRestTests {

    final MockMvc mvc;

    final Orders orders;

    @MockBean
    private OrderService orderService;

    @BeforeEach
    void setup() {
        var order = this.orders.findById(new Order.OrderId(UUID.fromString("bbb6f2f3-104b-489c-8048-ac08318a4898")))
                .orElseThrow();
        BDDMockito.given(orderService.createOrder(any())).willReturn(order);
    }

    @Test
    void list() throws Exception {
        this.mvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void create() throws Exception {
        File content = new ClassPathResource("order.json").getFile();
        this.mvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Files.contentOf(content, "UTF-8")))
                .andExpect(status().isCreated())
                .andDo(print());
    }
}
