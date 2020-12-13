package playground.order.internal;

import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.onion.simplified.DomainRing;
import org.jmolecules.ddd.annotation.Factory;
import org.springframework.stereotype.Component;
import playground.order.OrderNumber;
import playground.order.Orders;

@DomainRing // 自身の集約内の他のインスタンスの情報をみて処理する
@Factory
@Component
@RequiredArgsConstructor
public class OrderNumberGenerator {

    private final Orders orders;

    public OrderNumber generate() {
        // TODO: 最大の注文番号+1を返す
        return OrderNumber.of("ABC-12345");
    }

}
