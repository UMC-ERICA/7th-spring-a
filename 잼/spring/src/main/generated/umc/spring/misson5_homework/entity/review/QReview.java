package umc.spring.misson5_homework.entity.review;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = -1591412194L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReview review = new QReview("review");

    public final umc.spring.misson5_homework.base.QBaseEntity _super = new umc.spring.misson5_homework.base.QBaseEntity(this);

    public final StringPath comment = createString("comment");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> rating = createNumber("rating", Integer.class);

    public final umc.spring.misson5_homework.entity.restaurant.QRestaurant restaurant;

    public final ListPath<ReviewImage, QReviewImage> reviewImages = this.<ReviewImage, QReviewImage>createList("reviewImages", ReviewImage.class, QReviewImage.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateAt = _super.updateAt;

    public final umc.spring.misson5_homework.entity.user.QUser user;

    public QReview(String variable) {
        this(Review.class, forVariable(variable), INITS);
    }

    public QReview(Path<? extends Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReview(PathMetadata metadata, PathInits inits) {
        this(Review.class, metadata, inits);
    }

    public QReview(Class<? extends Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurant = inits.isInitialized("restaurant") ? new umc.spring.misson5_homework.entity.restaurant.QRestaurant(forProperty("restaurant"), inits.get("restaurant")) : null;
        this.user = inits.isInitialized("user") ? new umc.spring.misson5_homework.entity.user.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

