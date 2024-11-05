package umc.spring.misson5_homework.entity.mission;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMisson is a Querydsl query type for Misson
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMisson extends EntityPathBase<Misson> {

    private static final long serialVersionUID = -1513141114L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMisson misson = new QMisson("misson");

    public final umc.spring.misson5_homework.base.QBaseEntity _super = new umc.spring.misson5_homework.base.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final umc.spring.misson5_homework.entity.restaurant.QRestaurant restaurant;

    public final EnumPath<umc.spring.misson5_homework.enums.MissonState> state = createEnum("state", umc.spring.misson5_homework.enums.MissonState.class);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateAt = _super.updateAt;

    public final ListPath<umc.spring.misson5_homework.entity.user.UserMisson, umc.spring.misson5_homework.entity.user.QUserMisson> userMisson = this.<umc.spring.misson5_homework.entity.user.UserMisson, umc.spring.misson5_homework.entity.user.QUserMisson>createList("userMisson", umc.spring.misson5_homework.entity.user.UserMisson.class, umc.spring.misson5_homework.entity.user.QUserMisson.class, PathInits.DIRECT2);

    public final ListPath<VerifyMisson, QVerifyMisson> verifyMisson = this.<VerifyMisson, QVerifyMisson>createList("verifyMisson", VerifyMisson.class, QVerifyMisson.class, PathInits.DIRECT2);

    public QMisson(String variable) {
        this(Misson.class, forVariable(variable), INITS);
    }

    public QMisson(Path<? extends Misson> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMisson(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMisson(PathMetadata metadata, PathInits inits) {
        this(Misson.class, metadata, inits);
    }

    public QMisson(Class<? extends Misson> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurant = inits.isInitialized("restaurant") ? new umc.spring.misson5_homework.entity.restaurant.QRestaurant(forProperty("restaurant"), inits.get("restaurant")) : null;
    }

}

