package umc.spring.example.repository.missonRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;
import umc.spring.example.domain.enums.MissonStatus;
import umc.spring.example.domain.mapping.QMission;
import umc.spring.example.dto.MissonDTO;

import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public class MissonRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Autowired
    public MissonRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }


    @Override
    public Page<MissonDTO> getOngoingMissons(Pageable pageable) {

        QMission mission = QMission.mission;

        List<MissonDTO> missions = queryFactory
                .select(Projections.fields(MissonDTO.class,
                        mission.point,
                        mission.status,
                        mission.content))
                .from(mission)
                .where(mission.status.eq(MissonStatus.CHALLENGING))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory.selectFrom(mission)
                .where(mission.status.eq(MissonStatus.CHALLENGING))
                .fetchCount();

        return new PageImpl<>(missions, pageable, total);
    }

    @Override
    public Page<MissonDTO> getCompletedMissions(Pageable pageable) {
        QMission mission = QMission.mission;

        List<MissonDTO> missions = queryFactory
                .select(Projections.fields(MissonDTO.class,
                        mission.point,
                        mission.status,
                        mission.content))
                .from(mission)
                .where(mission.status.eq(MissonStatus.COMPLETE))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory.selectFrom(mission)
                .where(mission.status.eq(MissonStatus.COMPLETE))
                .fetchCount();

        return new PageImpl<>(missions, pageable, total);
    }
}
