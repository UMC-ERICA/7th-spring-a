package umc.spring.misson5_homework.entity.restaurant;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRestaurant is a Querydsl query type for Restaurant
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRestaurant extends EntityPathBase<Restaurant> {

    private static final long serialVersionUID = 1379339774L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRestaurant restaurant = new QRestaurant("restaurant");

    public final NumberPath<java.math.BigDecimal> averageRating = createNumber("averageRating", java.math.BigDecimal.class);

    public final QRestaurantCategory category;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.spring.misson5_homework.entity.mission.Misson, umc.spring.misson5_homework.entity.mission.QMisson> missonList = this.<umc.spring.misson5_homework.entity.mission.Misson, umc.spring.misson5_homework.entity.mission.QMisson>createList("missonList", umc.spring.misson5_homework.entity.mission.Misson.class, umc.spring.misson5_homework.entity.mission.QMisson.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final ListPath<RestaurantAddress, QRestaurantAddress> restaurantAddresses = this.<RestaurantAddress, QRestaurantAddress>createList("restaurantAddresses", RestaurantAddress.class, QRestaurantAddress.class, PathInits.DIRECT2);

    public final ListPath<RestaurantImage, QRestaurantImage> restaurantImages = this.<RestaurantImage, QRestaurantImage>createList("restaurantImages", RestaurantImage.class, QRestaurantImage.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.misson5_homework.enums.RestaurantStatus> restaurantStatus = createEnum("restaurantStatus", umc.spring.misson5_homework.enums.RestaurantStatus.class);

    public QRestaurant(String variable) {
        this(Restaurant.class, forVariable(variable), INITS);
    }

    public QRestaurant(Path<? extends Restaurant> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRestaurant(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRestaurant(PathMetadata metadata, PathInits inits) {
        this(Restaurant.class, metadata, inits);
    }

    public QRestaurant(Class<? extends Restaurant> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QRestaurantCategory(forProperty("category"), inits.get("category")) : null;
    }

}

