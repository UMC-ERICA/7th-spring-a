package UMC.spring.domain;

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

    private static final long serialVersionUID = -1168260506L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final UMC.spring.domain.baseEntity.QBaseEntity _super = new UMC.spring.domain.baseEntity.QBaseEntity(this);

    public final ListPath<Alarm, QAlarm> alarmList = this.<Alarm, QAlarm>createList("alarmList", Alarm.class, QAlarm.class, PathInits.DIRECT2);

    public final DatePath<java.time.LocalDate> birthdate = createDate("birthdate", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<UMC.spring.domain.enums.MemberGender> gender = createEnum("gender", UMC.spring.domain.enums.MemberGender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Inquiry, QInquiry> inquiryList = this.<Inquiry, QInquiry>createList("inquiryList", Inquiry.class, QInquiry.class, PathInits.DIRECT2);

    public final StringPath memberAddress = createString("memberAddress");

    public final ListPath<UMC.spring.domain.mapping.MemberAgreement, UMC.spring.domain.mapping.QMemberAgreement> memberAgreementList = this.<UMC.spring.domain.mapping.MemberAgreement, UMC.spring.domain.mapping.QMemberAgreement>createList("memberAgreementList", UMC.spring.domain.mapping.MemberAgreement.class, UMC.spring.domain.mapping.QMemberAgreement.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> memberInActivateTime = createDateTime("memberInActivateTime", java.time.LocalDateTime.class);

    public final ListPath<UMC.spring.domain.mapping.MemberMission, UMC.spring.domain.mapping.QMemberMission> memberMissionList = this.<UMC.spring.domain.mapping.MemberMission, UMC.spring.domain.mapping.QMemberMission>createList("memberMissionList", UMC.spring.domain.mapping.MemberMission.class, UMC.spring.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final StringPath memberName = createString("memberName");

    public final ListPath<UMC.spring.domain.mapping.MemberPrefer, UMC.spring.domain.mapping.QMemberPrefer> memberPreferList = this.<UMC.spring.domain.mapping.MemberPrefer, UMC.spring.domain.mapping.QMemberPrefer>createList("memberPreferList", UMC.spring.domain.mapping.MemberPrefer.class, UMC.spring.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final EnumPath<UMC.spring.domain.enums.MemberStatus> memberStatus = createEnum("memberStatus", UMC.spring.domain.enums.MemberStatus.class);

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final QRegion region;

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<UMC.spring.domain.enums.SocialLoginType> socialLoginType = createEnum("socialLoginType", UMC.spring.domain.enums.SocialLoginType.class);

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
        this.region = inits.isInitialized("region") ? new QRegion(forProperty("region")) : null;
    }

}

