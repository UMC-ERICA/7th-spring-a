package UMC.spring.service.memberMissionService;

import UMC.spring.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;

public interface MemberMissionQueryService {

    Page<MemberMission> getInProgressMissionByMember(Long memberId, Integer page);
}
