package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.member.Member;
import umc.spring.domain.mission.MemberMission;
import umc.spring.domain.mission.Mission;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.memberMissionRepository.MemberMissionRepository;
import umc.spring.repository.memberRepository.MemberRepository;
import umc.spring.web.dto.MemberResponseDTO;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository missionMissionRepository;



    @Override
    public MemberResponseDTO.MemberMissionResponseDTO addMemberMission(Long missionId, Long memberId){

        Member memberById = memberRepository.findById(memberId)
                .orElseThrow(()->new RuntimeException("회원을 찾을 수 없습니다"));

        Mission byId = missionRepository.findById(missionId)
                .orElseThrow(()->new RuntimeException("미션을 찾을 수 없습니다"));

        MemberMission newMission = MemberMission.builder()
                .status(Boolean.FALSE)
                .uuid(UUID.randomUUID().toString())
                .member(memberById)
                .mission(byId)
                .build();

        missionMissionRepository.save(newMission);

        return MemberResponseDTO.MemberMissionResponseDTO.builder()
                .id(newMission.getId())
                .build();

    }
}
