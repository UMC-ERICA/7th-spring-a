package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberFoodCategory is a Querydsl query type for MemberFoodCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberFoodCategory extends EntityPathBase<MemberFoodCategory> {

    private static final long serialVersionUID = -131848990L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberFoodCategory memberFoodCategory = new QMemberFoodCategory("memberFoodCategory");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final QFoodCategory foodCategory;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.member.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMemberFoodCategory(String variable) {
        this(MemberFoodCategory.class, forVariable(variable), INITS);
    }

    public QMemberFoodCategory(Path<? extends MemberFoodCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberFoodCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberFoodCategory(PathMetadata metadata, PathInits inits) {
        this(MemberFoodCategory.class, metadata, inits);
    }

    public QMemberFoodCategory(Class<? extends MemberFoodCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategory = inits.isInitialized("foodCategory") ? new QFoodCategory(forProperty("foodCategory")) : null;
        this.member = inits.isInitialized("member") ? new umc.spring.domain.member.QMember(forProperty("member"), inits.get("member")) : null;
    }

}

