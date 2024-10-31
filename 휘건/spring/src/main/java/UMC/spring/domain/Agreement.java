package UMC.spring.domain;

import UMC.spring.domain.baseEntity.BaseEntity;

import UMC.spring.domain.mapping.MemberAgreement;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class Agreement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(nullable = false)
    private String agreementContent;

    @Column(nullable = false, columnDefinition = "boolean default FALSE")
    private Boolean isAgree;

    // MemberAgreement OTM
    @OneToMany(mappedBy = "agreement", cascade = CascadeType.ALL)
    private List<MemberAgreement> memberAgreementList = new ArrayList<>();

}
