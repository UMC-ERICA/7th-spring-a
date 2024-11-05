package umc.spring.misson5_homework.entity.food;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFavoriteFood is a Querydsl query type for FavoriteFood
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFavoriteFood extends EntityPathBase<FavoriteFood> {

    private static final long serialVersionUID = 561182017L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFavoriteFood favoriteFood = new QFavoriteFood("favoriteFood");

    public final QFoodCategory foodCategory;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.misson5_homework.entity.user.QUser user;

    public QFavoriteFood(String variable) {
        this(FavoriteFood.class, forVariable(variable), INITS);
    }

    public QFavoriteFood(Path<? extends FavoriteFood> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFavoriteFood(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFavoriteFood(PathMetadata metadata, PathInits inits) {
        this(FavoriteFood.class, metadata, inits);
    }

    public QFavoriteFood(Class<? extends FavoriteFood> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategory = inits.isInitialized("foodCategory") ? new QFoodCategory(forProperty("foodCategory")) : null;
        this.user = inits.isInitialized("user") ? new umc.spring.misson5_homework.entity.user.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

