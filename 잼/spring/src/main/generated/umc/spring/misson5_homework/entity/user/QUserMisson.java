package umc.spring.misson5_homework.entity.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserMisson is a Querydsl query type for UserMisson
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserMisson extends EntityPathBase<UserMisson> {

    private static final long serialVersionUID = 776050912L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserMisson userMisson = new QUserMisson("userMisson");

    public final StringPath content = createString("content");

    public final DateTimePath<java.util.Date> deadline = createDateTime("deadline", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.misson5_homework.entity.mission.QMisson misson;

    public final EnumPath<umc.spring.misson5_homework.enums.MissonState> state = createEnum("state", umc.spring.misson5_homework.enums.MissonState.class);

    public final StringPath subtitle = createString("subtitle");

    public final StringPath title = createString("title");

    public final QUser user;

    public QUserMisson(String variable) {
        this(UserMisson.class, forVariable(variable), INITS);
    }

    public QUserMisson(Path<? extends UserMisson> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserMisson(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserMisson(PathMetadata metadata, PathInits inits) {
        this(UserMisson.class, metadata, inits);
    }

    public QUserMisson(Class<? extends UserMisson> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.misson = inits.isInitialized("misson") ? new umc.spring.misson5_homework.entity.mission.QMisson(forProperty("misson"), inits.get("misson")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

