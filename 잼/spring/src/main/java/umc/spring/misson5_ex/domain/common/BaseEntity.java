package umc.spring.misson5_ex.domain.common;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * MappedSuperclass :
 * 해당 클래스를 상속받는 모든 엔티티 클래스가 이 클래스의 매핑 정보 사용 가능
 * EntityListeners(AuditingEntityListener.class) :
 * 엔티티 수정, 생성될 때 자동으로 @CreatedDate와 @LastModifiedDate 어노테이션이 적용된 필드를 업데이트
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
