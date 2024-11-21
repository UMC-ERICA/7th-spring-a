package umc.spring.service;

import org.springframework.stereotype.Service;
import umc.spring.web.dto.MemberResponseDTO;

@Service
public interface MemberMissionService {
    MemberResponseDTO.MemberMissionResponseDTO addMemberMission(Long missionId, Long memberId);
}
