package playground.order;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author KOGA, Yu
 */
@Embeddable
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "of")
public class OrderNumber implements Serializable {

    private final String number;
}
