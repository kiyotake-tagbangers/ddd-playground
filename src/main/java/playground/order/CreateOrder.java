package playground.order;

import java.util.List;

/**
 * command にあたる
 * 注文する時に必要な情報
 * @author KIYOTA, Takeshi
 */
public class CreateOrder {

    private List<OrderLine> lines;

    private String customerName;

    private String creditCardNumber;

    public List<OrderLine> getLines() {
        return lines;
    }

    public void setLines(List<OrderLine> lines) {
        this.lines = lines;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
