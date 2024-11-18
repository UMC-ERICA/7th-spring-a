package UMC.spring.service.storeService;

import UMC.spring.domain.Region;
import UMC.spring.domain.Store;
import UMC.spring.domain.enums.FoodCategory;
import UMC.spring.repository.regionRepository.RegionRepository;
import UMC.spring.repository.storeRepository.StoreRepository;
import UMC.spring.web.dto.storeDTO.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public Store CreateStore(StoreRequestDTO.CreateStoreDTO request) {

        Region region = regionRepository.findByCityAndDistrictAndNeighborhood(
                request.getCity(),
                request.getDistrict(),
                request.getNeighborhood()
        ).orElseThrow(() -> new IllegalArgumentException("Region not found"));

        FoodCategory category = FoodCategory.fromString(request.getStoreCategory());

        Store newStore = Store.builder()
                .storeName(request.getName())
                .storeAddress(request.getStoreAddress())
                .storeCategory(category)
                .storeRate(BigDecimal.ZERO)
                .region(region)
                .build();


        return storeRepository.save(newStore);
    }
}
