package umc.spring.misson5_homework.entity.restaurant;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRestaurantAddress is a Querydsl query type for RestaurantAddress
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRestaurantAddress extends EntityPathBase<RestaurantAddress> {

    private static final long serialVersionUID = 191943567L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRestaurantAddress restaurantAddress = new QRestaurantAddress("restaurantAddress");

    public final umc.spring.misson5_homework.base.QBaseEntity _super = new umc.spring.misson5_homework.base.QBaseEntity(this);

    public final StringPath city = createString("city");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    public final StringPath detail = createString("detail");

    public final StringPath distinct = createString("distinct");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath neighborhood = createString("neighborhood");

    public final QRestaurant restaurant;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateAt = _super.updateAt;

    public QRestaurantAddress(String variable) {
        this(RestaurantAddress.class, forVariable(variable), INITS);
    }

    public QRestaurantAddress(Path<? extends RestaurantAddress> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRestaurantAddress(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRestaurantAddress(PathMetadata metadata, PathInits inits) {
        this(RestaurantAddress.class, metadata, inits);
    }

    public QRestaurantAddress(Class<? extends RestaurantAddress> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurant = inits.isInitialized("restaurant") ? new QRestaurant(forProperty("restaurant"), inits.get("restaurant")) : null;
    }

}

