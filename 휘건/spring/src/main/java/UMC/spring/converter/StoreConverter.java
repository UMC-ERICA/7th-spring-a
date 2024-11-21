package UMC.spring.converter;

import UMC.spring.domain.Region;
import UMC.spring.domain.Store;
import UMC.spring.domain.enums.FoodCategory;
import UMC.spring.web.dto.storeDTO.StoreRequestDTO;
import UMC.spring.web.dto.storeDTO.StoreResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.CreateStoreResultDTO toCreateResultDTO(Store store) {

        return StoreResponseDTO.CreateStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }


    public static Store toStore(StoreRequestDTO.CreateStoreDTO request,FoodCategory category ,Region region) {


        return  Store.builder()
                .storeName(request.getName())
                .storeAddress(request.getStoreAddress())
                .storeCategory(category)
                .storeRate(BigDecimal.ZERO)
                .region(region)
                .build();
    }
}
