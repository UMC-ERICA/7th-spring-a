package UMC.spring.service.missionService;

import UMC.spring.api.code.status.ErrorStatus;
import UMC.spring.api.exception.handler.StoreHandler;
import UMC.spring.domain.Mission;
import UMC.spring.domain.Store;
import UMC.spring.repository.missionRepository.MissionRepository;
import UMC.spring.repository.storeRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public Page<Mission> getMissionListByStore(Long storeId, Integer page) {

        int validatePage = page - 1;

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));


        return missionRepository.findAllByStore(store, PageRequest.of(validatePage, 10));
    }

}
