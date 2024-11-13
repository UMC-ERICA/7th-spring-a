package umc.spring.misson5_homework.entity.mission;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVerifyMisson is a Querydsl query type for VerifyMisson
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVerifyMisson extends EntityPathBase<VerifyMisson> {

    private static final long serialVersionUID = 62850470L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVerifyMisson verifyMisson = new QVerifyMisson("verifyMisson");

    public final StringPath belowText = createString("belowText");

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMisson misson;

    public final EnumPath<umc.spring.misson5_homework.enums.VerificationStatus> success = createEnum("success", umc.spring.misson5_homework.enums.VerificationStatus.class);

    public final StringPath variationCode = createString("variationCode");

    public final DateTimePath<java.time.LocalDateTime> verifiedAt = createDateTime("verifiedAt", java.time.LocalDateTime.class);

    public QVerifyMisson(String variable) {
        this(VerifyMisson.class, forVariable(variable), INITS);
    }

    public QVerifyMisson(Path<? extends VerifyMisson> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVerifyMisson(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVerifyMisson(PathMetadata metadata, PathInits inits) {
        this(VerifyMisson.class, metadata, inits);
    }

    public QVerifyMisson(Class<? extends VerifyMisson> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.misson = inits.isInitialized("misson") ? new QMisson(forProperty("misson"), inits.get("misson")) : null;
    }

}

