package UMC.spring.repository.memberMissionRepository;

import UMC.spring.domain.Member;
import UMC.spring.domain.Review;
import UMC.spring.domain.enums.MissionStatus;
import UMC.spring.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {

    boolean existsByMemberIdAndMissionIdAndMissionStatus(Long memberId, Long missionId, MissionStatus missionStatus);
    Page<MemberMission> findByMemberIdAndMissionStatus(Long memberId, MissionStatus missionStatus, PageRequest pageRequest);

    Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long missionId);
}
