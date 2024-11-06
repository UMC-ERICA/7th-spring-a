package UMC.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAgreement is a Querydsl query type for Agreement
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAgreement extends EntityPathBase<Agreement> {

    private static final long serialVersionUID = -1895074114L;

    public static final QAgreement agreement = new QAgreement("agreement");

    public final UMC.spring.domain.baseEntity.QBaseEntity _super = new UMC.spring.domain.baseEntity.QBaseEntity(this);

    public final StringPath agreementContent = createString("agreementContent");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isAgree = createBoolean("isAgree");

    public final ListPath<UMC.spring.domain.mapping.MemberAgreement, UMC.spring.domain.mapping.QMemberAgreement> memberAgreementList = this.<UMC.spring.domain.mapping.MemberAgreement, UMC.spring.domain.mapping.QMemberAgreement>createList("memberAgreementList", UMC.spring.domain.mapping.MemberAgreement.class, UMC.spring.domain.mapping.QMemberAgreement.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAgreement(String variable) {
        super(Agreement.class, forVariable(variable));
    }

    public QAgreement(Path<? extends Agreement> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAgreement(PathMetadata metadata) {
        super(Agreement.class, metadata);
    }

}

