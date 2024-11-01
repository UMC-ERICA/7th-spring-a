package UMC.spring.domain;

import UMC.spring.domain.baseEntity.BaseEntity;

import UMC.spring.domain.enums.FoodCategory;
import UMC.spring.domain.mapping.MemberPrefer;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class Prefer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private FoodCategory foodCategory;

    // MemberPrefer OTM
    @OneToMany(mappedBy = "prefer", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();
}
