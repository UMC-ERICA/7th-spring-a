package UMC.spring.service.storeService;

import UMC.spring.domain.Store;
import UMC.spring.web.dto.storeDTO.StoreRequestDTO;

public interface StoreCommandService {

    Store CreateStore(StoreRequestDTO.CreateStoreDTO request);
}
