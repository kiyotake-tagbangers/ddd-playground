package playground.order;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * command にあたる
 * 注文する時に必要な情報
 * @author KIYOTA, Takeshi
 */
@Getter
@Setter
public class CreateOrder {

    private List<OrderLine> lines;

    private String customerName;

    private String creditCardNumber;
}
