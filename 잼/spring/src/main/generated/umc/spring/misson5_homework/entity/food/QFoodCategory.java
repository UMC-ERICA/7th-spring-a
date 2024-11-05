package umc.spring.misson5_homework.entity.food;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFoodCategory is a Querydsl query type for FoodCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFoodCategory extends EntityPathBase<FoodCategory> {

    private static final long serialVersionUID = 2139605155L;

    public static final QFoodCategory foodCategory = new QFoodCategory("foodCategory");

    public final ListPath<FavoriteFood, QFavoriteFood> favoriteFoods = this.<FavoriteFood, QFavoriteFood>createList("favoriteFoods", FavoriteFood.class, QFavoriteFood.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<umc.spring.misson5_homework.entity.restaurant.RestaurantCategory, umc.spring.misson5_homework.entity.restaurant.QRestaurantCategory> restaurantCategories = this.<umc.spring.misson5_homework.entity.restaurant.RestaurantCategory, umc.spring.misson5_homework.entity.restaurant.QRestaurantCategory>createList("restaurantCategories", umc.spring.misson5_homework.entity.restaurant.RestaurantCategory.class, umc.spring.misson5_homework.entity.restaurant.QRestaurantCategory.class, PathInits.DIRECT2);

    public QFoodCategory(String variable) {
        super(FoodCategory.class, forVariable(variable));
    }

    public QFoodCategory(Path<? extends FoodCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFoodCategory(PathMetadata metadata) {
        super(FoodCategory.class, metadata);
    }

}

