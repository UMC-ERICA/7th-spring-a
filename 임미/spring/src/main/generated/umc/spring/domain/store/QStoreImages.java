package umc.spring.domain.store;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreImages is a Querydsl query type for StoreImages
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreImages extends EntityPathBase<StoreImages> {

    private static final long serialVersionUID = -541100544L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoreImages storeImages = new QStoreImages("storeImages");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath path = createString("path");

    public final QStore store;

    public QStoreImages(String variable) {
        this(StoreImages.class, forVariable(variable), INITS);
    }

    public QStoreImages(Path<? extends StoreImages> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoreImages(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoreImages(PathMetadata metadata, PathInits inits) {
        this(StoreImages.class, metadata, inits);
    }

    public QStoreImages(Class<? extends StoreImages> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

