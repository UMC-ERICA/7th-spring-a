package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayLoad.code.status.ErrorStatus;
import umc.spring.apiPayLoad.exception.handler.MissionCategoryHandler;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.member.Member;
import umc.spring.domain.mission.MemberMission;
import umc.spring.domain.mission.Mission;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.memberMissionRepository.MemberMissionRepository;
import umc.spring.repository.memberRepository.MemberRepository;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.web.dto.MissionDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;


    @Override
    public MemberResponseDTO.MemberMissionResponseDTO addMemberMission(Long missionId, Long memberId){

        Member memberById = memberRepository.findById(memberId)
                .orElseThrow(()->new RuntimeException("회원을 찾을 수 없습니다"));

        Mission byId = missionRepository.findById(missionId)
                .orElseThrow(()->new RuntimeException("미션을 찾을 수 없습니다"));

        MemberMission newMission = MemberMissionConverter.convert(byId,memberById);

        memberMissionRepository.save(newMission);

        return MemberResponseDTO.MemberMissionResponseDTO.builder()
                .id(newMission.getId())
                .build();
    }


    @Override
    public List<MissionDTO.MemberMissionResponseDTO> getMemberMission(Long memberId, Integer page){

        int size=10;

        Pageable pageable = PageRequest.of(page - 1, size);

        Page<MemberMission> findMemberMissions = memberMissionRepository.findByMemberIdAndStatusTrue(memberId,pageable);

        List<Mission> findMissions = findMemberMissions.stream().map(
                        findMission -> missionRepository.findById(findMission.getId())
                                .orElseThrow(()->new MissionCategoryHandler(ErrorStatus.MISSION_NOT_FOUND)))
                .collect(Collectors.toList());

        List<MissionDTO.MemberMissionResponseDTO> response = MemberMissionConverter.toMissionDTO(findMissions);

        return response;
    }

}
