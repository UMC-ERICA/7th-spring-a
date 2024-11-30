package UMC.spring.service.memberMissionService;

import UMC.spring.domain.enums.MissionStatus;
import UMC.spring.domain.mapping.MemberMission;
import UMC.spring.repository.memberMissionRepository.MemberMissionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService{

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<MemberMission> getInProgressMissionByMember(Long memberId, Integer page) {

        int validatePage = page - 1;

        return memberMissionRepository.findByMemberIdAndMissionStatus(memberId, MissionStatus.IN_PROGRESS, PageRequest.of(validatePage, 10));
    }

}
