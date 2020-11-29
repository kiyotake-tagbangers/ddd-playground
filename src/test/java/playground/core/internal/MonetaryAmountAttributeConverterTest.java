package playground.core.internal;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author KIYOTA, Takeshi
 */
class MonetaryAmountAttributeConverterTest {
    MonetaryAmountAttributeConverter converter = new MonetaryAmountAttributeConverter();

    @Test
    void deserializesFormattedValues() {
        assertThat(converter.convertToEntityAttribute("JPY 5,432")).isEqualTo(Money.of(5432, "JPY"));
    }
}