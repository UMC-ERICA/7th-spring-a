package UMC.spring.service.storeService;

import UMC.spring.api.code.BaseErrorCode;
import UMC.spring.api.code.status.ErrorStatus;
import UMC.spring.api.exception.handler.RegionHandler;
import UMC.spring.converter.StoreConverter;
import UMC.spring.domain.Region;
import UMC.spring.domain.Store;
import UMC.spring.domain.enums.FoodCategory;
import UMC.spring.repository.regionRepository.RegionRepository;
import UMC.spring.repository.storeRepository.StoreRepository;
import UMC.spring.web.dto.storeDTO.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


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
        ).orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        FoodCategory category = FoodCategory.fromString(request.getStoreCategory());

        Store newStore = StoreConverter.toStore(request, category ,region);

        return storeRepository.save(newStore);
    }

    @Override
    public Boolean isStoreExist(Long storeId) {

        return storeRepository.existsById(storeId);
    }
}
