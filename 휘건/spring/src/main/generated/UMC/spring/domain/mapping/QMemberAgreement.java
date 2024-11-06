package UMC.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberAgreement is a Querydsl query type for MemberAgreement
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberAgreement extends EntityPathBase<MemberAgreement> {

    private static final long serialVersionUID = -2075883228L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberAgreement memberAgreement = new QMemberAgreement("memberAgreement");

    public final UMC.spring.domain.baseEntity.QBaseEntity _super = new UMC.spring.domain.baseEntity.QBaseEntity(this);

    public final UMC.spring.domain.QAgreement agreement;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final UMC.spring.domain.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMemberAgreement(String variable) {
        this(MemberAgreement.class, forVariable(variable), INITS);
    }

    public QMemberAgreement(Path<? extends MemberAgreement> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberAgreement(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberAgreement(PathMetadata metadata, PathInits inits) {
        this(MemberAgreement.class, metadata, inits);
    }

    public QMemberAgreement(Class<? extends MemberAgreement> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.agreement = inits.isInitialized("agreement") ? new UMC.spring.domain.QAgreement(forProperty("agreement")) : null;
        this.member = inits.isInitialized("member") ? new UMC.spring.domain.QMember(forProperty("member"), inits.get("member")) : null;
    }

}

