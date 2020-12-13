package playground.core.internal;

import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.spi.MetadataBuilderContributor;
import org.hibernate.type.UUIDCharType;
import java.util.UUID;

/**
 * UUID カラムに @Type(type = "uuid-char") をつけなくて良いように hibernate の設定をカスタムする
 * @author KIYOTA, Takeshi
 */
public class UUIDMetadataBuilderContributor implements MetadataBuilderContributor {
    @Override
    public void contribute(MetadataBuilder metadataBuilder) {
        metadataBuilder.applyBasicType(UUIDCharType.INSTANCE, UUID.class.getName());
    }
}
