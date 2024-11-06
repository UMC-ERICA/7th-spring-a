package umc.spring.example.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberMission is a Querydsl query type for MemberMission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberMission extends EntityPathBase<MemberMission> {

    private static final long serialVersionUID = 718590794L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberMission memberMission = new QMemberMission("memberMission");

    public final umc.spring.example.domain.common.QBaseEntity _super = new umc.spring.example.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.example.domain.QMember member;

    public final QMission mission;

    public final StringPath state = createString("state");

    public final EnumPath<umc.spring.example.domain.enums.MissonStatus> status = createEnum("status", umc.spring.example.domain.enums.MissonStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMemberMission(String variable) {
        this(MemberMission.class, forVariable(variable), INITS);
    }

    public QMemberMission(Path<? extends MemberMission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberMission(PathMetadata metadata, PathInits inits) {
        this(MemberMission.class, metadata, inits);
    }

    public QMemberMission(Class<? extends MemberMission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new umc.spring.example.domain.QMember(forProperty("member"), inits.get("member")) : null;
        this.mission = inits.isInitialized("mission") ? new QMission(forProperty("mission"), inits.get("mission")) : null;
    }

}

