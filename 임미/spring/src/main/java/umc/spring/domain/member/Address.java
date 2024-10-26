package umc.spring.domain.member;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.store.Store;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* 시/도 */
    private String province;

    /* 시/군/구 */
    private String city;

    /* 읍/면/동 */
    private String town;

    /* 상세주소 */
    private String details;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Member member;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Store store;
}
