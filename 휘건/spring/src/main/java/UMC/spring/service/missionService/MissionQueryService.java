package UMC.spring.service.missionService;

import UMC.spring.domain.Mission;
import org.springframework.data.domain.Page;

public interface MissionQueryService {

    Page<Mission> getMissionListByStore(Long storeId, Integer page);
}
