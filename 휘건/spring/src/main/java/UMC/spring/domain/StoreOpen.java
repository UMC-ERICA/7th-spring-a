package UMC.spring.domain;

import UMC.spring.domain.baseEntity.BaseEntity;
import UMC.spring.domain.enums.Day;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class StoreOpen extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Day openDay;

    private LocalDateTime openTime;

    private LocalDateTime closeTime;

    // Store MTO
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;




}
