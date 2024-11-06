package UMC.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreOpen is a Querydsl query type for StoreOpen
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreOpen extends EntityPathBase<StoreOpen> {

    private static final long serialVersionUID = -1179033729L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoreOpen storeOpen = new QStoreOpen("storeOpen");

    public final UMC.spring.domain.baseEntity.QBaseEntity _super = new UMC.spring.domain.baseEntity.QBaseEntity(this);

    public final DateTimePath<java.time.LocalDateTime> closeTime = createDateTime("closeTime", java.time.LocalDateTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<UMC.spring.domain.enums.Day> openDay = createEnum("openDay", UMC.spring.domain.enums.Day.class);

    public final DateTimePath<java.time.LocalDateTime> openTime = createDateTime("openTime", java.time.LocalDateTime.class);

    public final QStore store;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QStoreOpen(String variable) {
        this(StoreOpen.class, forVariable(variable), INITS);
    }

    public QStoreOpen(Path<? extends StoreOpen> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoreOpen(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoreOpen(PathMetadata metadata, PathInits inits) {
        this(StoreOpen.class, metadata, inits);
    }

    public QStoreOpen(Class<? extends StoreOpen> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

