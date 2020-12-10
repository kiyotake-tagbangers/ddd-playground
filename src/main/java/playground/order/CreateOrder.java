package playground.order;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * command にあたる
 * @author KIYOTA, Takeshi
 */
@Getter
@Setter
public class CreateOrder {

    private List<OrderLine> lines;

    private String customerName;
}
