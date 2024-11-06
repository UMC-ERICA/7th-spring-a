package UMC.spring.domain;

import UMC.spring.domain.baseEntity.BaseEntity;
import UMC.spring.domain.enums.FoodCategory;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String storeName;

    @Column(nullable = false, length = 100)
    private String storeAddress;

    @Column(precision = 3, scale = 2)
    private BigDecimal storeRate;

    @Enumerated(EnumType.STRING)
    private FoodCategory storeCategory;

    // Region MTO
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    // Mission OTM
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    // StoreOpen OTM
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<StoreOpen> storeOpenList = new ArrayList<>();

    // Review OTM
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + storeName + '\'' +
                ", address='" + storeAddress + '\'' +
                ", score=" + storeRate +
                '}';
    }
}
