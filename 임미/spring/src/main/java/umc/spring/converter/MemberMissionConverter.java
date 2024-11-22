package umc.spring.converter;

import umc.spring.domain.member.Member;
import umc.spring.domain.mission.MemberMission;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.store.Store;

import java.util.UUID;

public class MemberMissionConverter {

    public static MemberMission convert(Mission byId, Member memberById) {

        return MemberMission.builder()
                .status(Boolean.FALSE)
                .uuid(UUID.randomUUID().toString())
                .member(memberById)
                .mission(byId)
                .build();
    }
}
