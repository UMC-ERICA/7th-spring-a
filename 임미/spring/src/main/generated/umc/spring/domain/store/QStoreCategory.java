package umc.spring.domain.store;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreCategory is a Querydsl query type for StoreCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreCategory extends EntityPathBase<StoreCategory> {

    private static final long serialVersionUID = 603516550L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoreCategory storeCategory = new QStoreCategory("storeCategory");

    public final umc.spring.domain.QFoodCategory foodCategory;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QStore store;

    public QStoreCategory(String variable) {
        this(StoreCategory.class, forVariable(variable), INITS);
    }

    public QStoreCategory(Path<? extends StoreCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoreCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoreCategory(PathMetadata metadata, PathInits inits) {
        this(StoreCategory.class, metadata, inits);
    }

    public QStoreCategory(Class<? extends StoreCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategory = inits.isInitialized("foodCategory") ? new umc.spring.domain.QFoodCategory(forProperty("foodCategory")) : null;
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

