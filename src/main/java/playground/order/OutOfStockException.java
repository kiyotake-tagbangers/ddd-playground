package playground.order;

/**
 * @author KOGA, Yu
 */
public class OutOfStockException extends RuntimeException {

    public OutOfStockException(String message) {
        super(message);
    }
}
