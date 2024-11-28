package UMC.spring.service.memberMissionService;

import UMC.spring.api.code.status.ErrorStatus;
import UMC.spring.api.exception.handler.MemberHandler;
import UMC.spring.api.exception.handler.MemberMissionHandler;
import UMC.spring.api.exception.handler.MissionHandler;
import UMC.spring.domain.Member;
import UMC.spring.domain.Mission;
import UMC.spring.domain.enums.MissionStatus;
import UMC.spring.domain.mapping.MemberMission;
import UMC.spring.repository.memberMissionRepository.MemberMissionRepository;
import UMC.spring.repository.memberRepository.MemberRepository;
import UMC.spring.repository.missionRepository.MissionRepository;
import UMC.spring.web.dto.memberMissionDTO.MemberMissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;


    @Override
    public MemberMission createMemberMission(MemberMissionRequestDTO.CreateMemberMissionDTO request, Long storeId, Long missionId) {

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        if (!missionRepository.existsByIdAndStoreId(missionId, storeId)) {
            throw new MissionHandler(ErrorStatus.MISSION_NOT_BELONGS_TO_STORE);
        }

        if (memberMissionRepository.existsByMemberIdAndMissionIdAndMissionStatus(member.getId(), missionId, MissionStatus.IN_PROGRESS)) {
            throw new MissionHandler(ErrorStatus.DUPLICATE_MISSION_IN_PROGRESS); // 커스텀 예외
        }

        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();

        return memberMissionRepository.save(memberMission);
    }

    @Override
    public MemberMission updateMissionStatus(Long memberId, Long missionId) {
        MemberMission memberMission = memberMissionRepository.findByMemberIdAndMissionId(memberId, missionId)
                .orElseThrow(() -> new MemberMissionHandler(ErrorStatus.MEMBER_MISSION_NOT_FOUND));


        if (memberMission.getMissionStatus() == MissionStatus.COMPLETED) {
            throw new MemberMissionHandler(ErrorStatus.MEMBER_MISSION_ALREADY_COMPLETED);
        }


        memberMission.setMissionStatus(MissionStatus.COMPLETED);

        return memberMissionRepository.save(memberMission);
    }


}
