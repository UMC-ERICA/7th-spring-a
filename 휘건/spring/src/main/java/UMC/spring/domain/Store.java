package UMC.spring.domain;

import UMC.spring.domain.baseEntity.BaseEntity;
import UMC.spring.domain.enums.FoodCategory;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
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
    @ColumnDefault("0.0")
    private BigDecimal storeRate;

    @ColumnDefault("0")
    private BigDecimal totalRate;

    @ColumnDefault("0")
    private Integer reviewCount;

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

    public void updateStoreRate(BigDecimal newReviewRate) {

        this.totalRate = this.totalRate.add(newReviewRate);

        this.reviewCount ++;

        this.storeRate = this.totalRate.divide(BigDecimal.valueOf(this.reviewCount), 2, RoundingMode.HALF_UP);
    }

    public void removeReviewRate(BigDecimal reviewRate) {
        this.totalRate = this.totalRate.subtract(reviewRate);

        this.reviewCount --;

        this.storeRate = this.reviewCount > 0
                ? this.totalRate.divide(BigDecimal.valueOf(this.reviewCount), 2, RoundingMode.HALF_UP)
                : BigDecimal.ZERO;
    }
}
