package umc.spring.converter;

import umc.spring.domain.member.Member;
import umc.spring.domain.mission.MemberMission;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.store.Store;
import umc.spring.web.dto.MissionDTO;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static MemberMission convert(Mission byId, Member memberById) {

        return MemberMission.builder()
                .status(Boolean.FALSE)
                .uuid(UUID.randomUUID().toString())
                .member(memberById)
                .mission(byId)
                .build();
    }

    public static List<MissionDTO.MemberMissionResponseDTO> toMissionDTO(List<Mission> findMissions) {

        return findMissions.stream().map(
                        findMission-> MissionDTO.MemberMissionResponseDTO.builder()
                                .missionId(findMission.getId())
                                .content(findMission.getContent())
                                .point(findMission.getPoint())
                                .build())
                .collect(Collectors.toList());
    }
}
