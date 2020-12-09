package playground.order;

import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author KOGA, Yu
 */
@Embeddable
@RequiredArgsConstructor(staticName = "of")
public class OrderNumber implements Serializable {

    private final String orderNumber;

    protected OrderNumber() {
        this.orderNumber = null;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
}
