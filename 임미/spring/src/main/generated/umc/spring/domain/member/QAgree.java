package umc.spring.domain.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAgree is a Querydsl query type for Agree
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAgree extends EntityPathBase<Agree> {

    private static final long serialVersionUID = -278206268L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAgree agree = new QAgree("agree");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final BooleanPath ageAgree = createBoolean("ageAgree");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final BooleanPath detailsAgree = createBoolean("detailsAgree");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath locationAgree = createBoolean("locationAgree");

    public final BooleanPath marketingAlarmAgree = createBoolean("marketingAlarmAgree");

    public final QMember member;

    public final BooleanPath serviceAgree = createBoolean("serviceAgree");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAgree(String variable) {
        this(Agree.class, forVariable(variable), INITS);
    }

    public QAgree(Path<? extends Agree> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAgree(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAgree(PathMetadata metadata, PathInits inits) {
        this(Agree.class, metadata, inits);
    }

    public QAgree(Class<? extends Agree> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
    }

}

