package UMC.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPrefer is a Querydsl query type for Prefer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPrefer extends EntityPathBase<Prefer> {

    private static final long serialVersionUID = -1070601764L;

    public static final QPrefer prefer = new QPrefer("prefer");

    public final UMC.spring.domain.baseEntity.QBaseEntity _super = new UMC.spring.domain.baseEntity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<UMC.spring.domain.enums.FoodCategory> foodCategory = createEnum("foodCategory", UMC.spring.domain.enums.FoodCategory.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<UMC.spring.domain.mapping.MemberPrefer, UMC.spring.domain.mapping.QMemberPrefer> memberPreferList = this.<UMC.spring.domain.mapping.MemberPrefer, UMC.spring.domain.mapping.QMemberPrefer>createList("memberPreferList", UMC.spring.domain.mapping.MemberPrefer.class, UMC.spring.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QPrefer(String variable) {
        super(Prefer.class, forVariable(variable));
    }

    public QPrefer(Path<? extends Prefer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPrefer(PathMetadata metadata) {
        super(Prefer.class, metadata);
    }

}

