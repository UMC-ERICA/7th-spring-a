package umc.spring.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.web.dto.MissionDTO;

import java.util.List;

@Service
public interface MemberMissionService {
    MemberResponseDTO.MemberMissionResponseDTO addMemberMission(Long missionId, Long memberId);

    List<MissionDTO.MemberMissionResponseDTO> getMemberMission(Long memberId, Integer page);
}
