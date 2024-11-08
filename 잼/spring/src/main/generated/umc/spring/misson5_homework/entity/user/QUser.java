package umc.spring.misson5_homework.entity.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1966888830L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final umc.spring.misson5_homework.base.QBaseEntity _super = new umc.spring.misson5_homework.base.QBaseEntity(this);

    public final DatePath<java.time.LocalDate> birthday = createDate("birthday", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    public final ListPath<umc.spring.misson5_homework.entity.food.FavoriteFood, umc.spring.misson5_homework.entity.food.QFavoriteFood> favoriteFoods = this.<umc.spring.misson5_homework.entity.food.FavoriteFood, umc.spring.misson5_homework.entity.food.QFavoriteFood>createList("favoriteFoods", umc.spring.misson5_homework.entity.food.FavoriteFood.class, umc.spring.misson5_homework.entity.food.QFavoriteFood.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.misson5_homework.enums.Gender> gender = createEnum("gender", umc.spring.misson5_homework.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<umc.spring.misson5_homework.entity.notice.Notice, umc.spring.misson5_homework.entity.notice.QNotice> notices = this.<umc.spring.misson5_homework.entity.notice.Notice, umc.spring.misson5_homework.entity.notice.QNotice>createList("notices", umc.spring.misson5_homework.entity.notice.Notice.class, umc.spring.misson5_homework.entity.notice.QNotice.class, PathInits.DIRECT2);

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<umc.spring.misson5_homework.entity.question.Question, umc.spring.misson5_homework.entity.question.QQuestion> questions = this.<umc.spring.misson5_homework.entity.question.Question, umc.spring.misson5_homework.entity.question.QQuestion>createList("questions", umc.spring.misson5_homework.entity.question.Question.class, umc.spring.misson5_homework.entity.question.QQuestion.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.misson5_homework.entity.review.Review, umc.spring.misson5_homework.entity.review.QReview> reviews = this.<umc.spring.misson5_homework.entity.review.Review, umc.spring.misson5_homework.entity.review.QReview>createList("reviews", umc.spring.misson5_homework.entity.review.Review.class, umc.spring.misson5_homework.entity.review.QReview.class, PathInits.DIRECT2);

    public final ListPath<SocialLogin, QSocialLogin> socialLogins = this.<SocialLogin, QSocialLogin>createList("socialLogins", SocialLogin.class, QSocialLogin.class, PathInits.DIRECT2);

    public final BooleanPath termsAccepted = createBoolean("termsAccepted");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateAt = _super.updateAt;

    public final QUserAddress userAddress;

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userAddress = inits.isInitialized("userAddress") ? new QUserAddress(forProperty("userAddress"), inits.get("userAddress")) : null;
    }

}

