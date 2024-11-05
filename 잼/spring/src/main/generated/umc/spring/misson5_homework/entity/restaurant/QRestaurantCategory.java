package umc.spring.misson5_homework.entity.restaurant;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRestaurantCategory is a Querydsl query type for RestaurantCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRestaurantCategory extends EntityPathBase<RestaurantCategory> {

    private static final long serialVersionUID = -1370457917L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRestaurantCategory restaurantCategory = new QRestaurantCategory("restaurantCategory");

    public final umc.spring.misson5_homework.entity.food.QFoodCategory foodCategory;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<Restaurant, QRestaurant> restaurants = this.<Restaurant, QRestaurant>createList("restaurants", Restaurant.class, QRestaurant.class, PathInits.DIRECT2);

    public QRestaurantCategory(String variable) {
        this(RestaurantCategory.class, forVariable(variable), INITS);
    }

    public QRestaurantCategory(Path<? extends RestaurantCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRestaurantCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRestaurantCategory(PathMetadata metadata, PathInits inits) {
        this(RestaurantCategory.class, metadata, inits);
    }

    public QRestaurantCategory(Class<? extends RestaurantCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategory = inits.isInitialized("foodCategory") ? new umc.spring.misson5_homework.entity.food.QFoodCategory(forProperty("foodCategory")) : null;
    }

}

