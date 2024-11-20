package umc.spring.converter;

import umc.spring.domain.store.Store;
import umc.spring.web.dto.StoreDTO;

public class StoreConverter {

    public static Store toStore(StoreDTO.StoreSaveRequestDTO request) {

        return Store.builder()
                .name(request.getName())
                .score(0)
                .status(Boolean.TRUE)
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .build();
    }
}
