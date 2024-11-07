package umc.spring.domain.store;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStore is a Querydsl query type for Store
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStore extends EntityPathBase<Store> {

    private static final long serialVersionUID = 30651752L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStore store = new QStore("store");

    public final umc.spring.domain.member.QAddress address;

    public final DateTimePath<java.time.LocalDateTime> endTime = createDateTime("endTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.spring.domain.mission.Mission, umc.spring.domain.mission.QMission> missions = this.<umc.spring.domain.mission.Mission, umc.spring.domain.mission.QMission>createList("missions", umc.spring.domain.mission.Mission.class, umc.spring.domain.mission.QMission.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> score = createNumber("score", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> startTime = createDateTime("startTime", java.time.LocalDateTime.class);

    public final BooleanPath status = createBoolean("status");

    public final ListPath<StoreCategory, QStoreCategory> storeCategories = this.<StoreCategory, QStoreCategory>createList("storeCategories", StoreCategory.class, QStoreCategory.class, PathInits.DIRECT2);

    public final ListPath<StoreImages, QStoreImages> storeImages = this.<StoreImages, QStoreImages>createList("storeImages", StoreImages.class, QStoreImages.class, PathInits.DIRECT2);

    public QStore(String variable) {
        this(Store.class, forVariable(variable), INITS);
    }

    public QStore(Path<? extends Store> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStore(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStore(PathMetadata metadata, PathInits inits) {
        this(Store.class, metadata, inits);
    }

    public QStore(Class<? extends Store> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new umc.spring.domain.member.QAddress(forProperty("address"), inits.get("address")) : null;
    }

}

