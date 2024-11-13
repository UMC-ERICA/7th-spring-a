package umc.spring.domain.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 307091330L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final QAddress address;

    public final QAgree agree;

    public final QAlarm alarm;

    public final DatePath<java.time.LocalDate> birthday = createDate("birthday", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc.spring.domain.enumClass.Gender> gender = createEnum("gender", umc.spring.domain.enumClass.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.spring.domain.MemberFoodCategory, umc.spring.domain.QMemberFoodCategory> memberFoodCategories = this.<umc.spring.domain.MemberFoodCategory, umc.spring.domain.QMemberFoodCategory>createList("memberFoodCategories", umc.spring.domain.MemberFoodCategory.class, umc.spring.domain.QMemberFoodCategory.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.mission.MemberMission, umc.spring.domain.mission.QMemberMission> memberMissions = this.<umc.spring.domain.mission.MemberMission, umc.spring.domain.mission.QMemberMission>createList("memberMissions", umc.spring.domain.mission.MemberMission.class, umc.spring.domain.mission.QMemberMission.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Question, QQuestion> questions = this.<Question, QQuestion>createList("questions", Question.class, QQuestion.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.Review, umc.spring.domain.QReview> reviews = this.<umc.spring.domain.Review, umc.spring.domain.QReview>createList("reviews", umc.spring.domain.Review.class, umc.spring.domain.QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.domain.enumClass.Role> role = createEnum("role", umc.spring.domain.enumClass.Role.class);

    public final BooleanPath status = createBoolean("status");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddress(forProperty("address"), inits.get("address")) : null;
        this.agree = inits.isInitialized("agree") ? new QAgree(forProperty("agree"), inits.get("agree")) : null;
        this.alarm = inits.isInitialized("alarm") ? new QAlarm(forProperty("alarm"), inits.get("alarm")) : null;
    }

}

