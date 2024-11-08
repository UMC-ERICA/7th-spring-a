package umc.spring.example.domain;

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

    private static final long serialVersionUID = 198271682L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final StringPath address = createString("address");

    public final NumberPath<Long> completeMiss = createNumber("completeMiss", Long.class);

    public final StringPath email = createString("email");

    public final EnumPath<umc.spring.example.domain.enums.Gender> gender = createEnum("gender", umc.spring.example.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final umc.spring.example.domain.mapping.QMemberAddress memberAddress;

    public final ListPath<umc.spring.example.domain.mapping.MemberAgree, umc.spring.example.domain.mapping.QMemberAgree> memberAgreeList = this.<umc.spring.example.domain.mapping.MemberAgree, umc.spring.example.domain.mapping.QMemberAgree>createList("memberAgreeList", umc.spring.example.domain.mapping.MemberAgree.class, umc.spring.example.domain.mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.example.domain.mapping.MemberMission, umc.spring.example.domain.mapping.QMemberMission> memberMissions = this.<umc.spring.example.domain.mapping.MemberMission, umc.spring.example.domain.mapping.QMemberMission>createList("memberMissions", umc.spring.example.domain.mapping.MemberMission.class, umc.spring.example.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.example.domain.mapping.MemberPrefer, umc.spring.example.domain.mapping.QMemberPrefer> memberPreferList = this.<umc.spring.example.domain.mapping.MemberPrefer, umc.spring.example.domain.mapping.QMemberPrefer>createList("memberPreferList", umc.spring.example.domain.mapping.MemberPrefer.class, umc.spring.example.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final ListPath<umc.spring.example.domain.mapping.Notification, umc.spring.example.domain.mapping.QNotification> notifications = this.<umc.spring.example.domain.mapping.Notification, umc.spring.example.domain.mapping.QNotification>createList("notifications", umc.spring.example.domain.mapping.Notification.class, umc.spring.example.domain.mapping.QNotification.class, PathInits.DIRECT2);

    public final StringPath phone = createString("phone");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<umc.spring.example.domain.mapping.Review, umc.spring.example.domain.mapping.QReview> reviews = this.<umc.spring.example.domain.mapping.Review, umc.spring.example.domain.mapping.QReview>createList("reviews", umc.spring.example.domain.mapping.Review.class, umc.spring.example.domain.mapping.QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.example.domain.enums.SocialType> socialType = createEnum("socialType", umc.spring.example.domain.enums.SocialType.class);

    public final StringPath specAddress = createString("specAddress");

    public final EnumPath<umc.spring.example.domain.enums.MemberStatus> status = createEnum("status", umc.spring.example.domain.enums.MemberStatus.class);

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
        this.memberAddress = inits.isInitialized("memberAddress") ? new umc.spring.example.domain.mapping.QMemberAddress(forProperty("memberAddress")) : null;
    }

}

