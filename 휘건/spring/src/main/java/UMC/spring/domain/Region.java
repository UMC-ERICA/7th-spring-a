package UMC.spring.domain;

import UMC.spring.domain.baseEntity.BaseEntity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class Region extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String city;

    @Column(nullable = false, length = 10)
    private String district;

    @Column(nullable = false, length = 10)
    private String neighborhood;

    // Member OTM
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Member> memberList = new ArrayList<>();

    // Store OTM
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Store> storeList = new ArrayList<>();
}
