package umc.spring.domain.store;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.member.Address;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer score;

    private Boolean status;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @OneToOne(mappedBy = "store")
    private Address address;

    @OneToMany(mappedBy = "store")
    private List<StoreCategory> storeCategories=new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<StoreImages> storeImages=new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<Mission> missions=new ArrayList<>();


    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", score=" + score +
                '}';
    }


    public void setAddress(Address address) {
        if (address != null) {
            this.address = address;
        }
    }
}
