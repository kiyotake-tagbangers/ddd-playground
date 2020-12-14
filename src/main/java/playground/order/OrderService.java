package playground.order;

import org.jmolecules.architecture.onion.simplified.ApplicationRing;

/**
 * @author KIYOTA, Takeshi
 */
@ApplicationRing // 集約ルートをまたいで他の集約ルートを見る(アプリケーションサービス)
public interface OrderService {

    Order processOrder(CreateOrder command);
}
