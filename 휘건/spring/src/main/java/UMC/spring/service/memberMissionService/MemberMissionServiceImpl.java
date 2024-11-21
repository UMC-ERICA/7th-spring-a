package UMC.spring.service.memberMissionService;

import UMC.spring.api.code.status.ErrorStatus;
import UMC.spring.api.exception.handler.MemberHandler;
import UMC.spring.api.exception.handler.MissionHandler;
import UMC.spring.api.exception.handler.StoreHandler;
import UMC.spring.domain.Member;
import UMC.spring.domain.Mission;
import UMC.spring.domain.Store;
import UMC.spring.domain.mapping.MemberMission;
import UMC.spring.repository.memberMissionRepository.MemberMissionRepository;
import UMC.spring.repository.memberRepository.MemberRepository;
import UMC.spring.repository.missionRepository.MissionRepository;
import UMC.spring.repository.storeRepository.StoreRepository;
import UMC.spring.web.dto.memberMissionDTO.MemberMissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public MemberMission CreateMemberMission(MemberMissionRequestDTO.CreateMemberMissionDTO request, Long storeId, Long missionId) {

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        if (!missionRepository.existsByIdAndStoreId(missionId, storeId)) {
            throw new MissionHandler(ErrorStatus.MISSION_NOT_BELONGS_TO_STORE);
        }

        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();

        return memberMissionRepository.save(memberMission);
    }





}
