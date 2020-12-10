package playground.order;

import lombok.Getter;
import lombok.Setter;
import playground.customer.Customer;

import java.time.LocalDate;
import java.util.List;

/**
 * command にあたる
 * @author KIYOTA, Takeshi
 */
@Getter
@Setter
public class CreateOrder {

    private String orderNo;

    private LocalDate orderDate;

    private List<OrderLine> lines;

    // 注文する人
    private Customer.CustomerAssociation customer;

}
