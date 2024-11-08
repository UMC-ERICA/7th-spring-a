package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewImages is a Querydsl query type for ReviewImages
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewImages extends EntityPathBase<ReviewImages> {

    private static final long serialVersionUID = -48389476L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewImages reviewImages = new QReviewImages("reviewImages");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath path = createString("path");

    public final QReview review;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QReviewImages(String variable) {
        this(ReviewImages.class, forVariable(variable), INITS);
    }

    public QReviewImages(Path<? extends ReviewImages> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewImages(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewImages(PathMetadata metadata, PathInits inits) {
        this(ReviewImages.class, metadata, inits);
    }

    public QReviewImages(Class<? extends ReviewImages> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new QReview(forProperty("review"), inits.get("review")) : null;
    }

}

