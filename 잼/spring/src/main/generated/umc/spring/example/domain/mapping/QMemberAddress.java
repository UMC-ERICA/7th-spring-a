package umc.spring.example.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberAddress is a Querydsl query type for MemberAddress
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberAddress extends EntityPathBase<MemberAddress> {

    private static final long serialVersionUID = -1498550862L;

    public static final QMemberAddress memberAddress = new QMemberAddress("memberAddress");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath neighborhood = createString("neighborhood");

    public final ListPath<umc.spring.example.domain.Member, umc.spring.example.domain.QMember> users = this.<umc.spring.example.domain.Member, umc.spring.example.domain.QMember>createList("users", umc.spring.example.domain.Member.class, umc.spring.example.domain.QMember.class, PathInits.DIRECT2);

    public QMemberAddress(String variable) {
        super(MemberAddress.class, forVariable(variable));
    }

    public QMemberAddress(Path<? extends MemberAddress> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberAddress(PathMetadata metadata) {
        super(MemberAddress.class, metadata);
    }

}

