package umc.spring.example.repository.missonRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import umc.spring.example.domain.mapping.QMission;
import umc.spring.example.dto.MissonDTO;

import org.springframework.data.domain.Pageable;

import java.util.List;

import static umc.spring.example.domain.enums.MissonStatus.CHALLENGING;
import static umc.spring.example.domain.enums.MissonStatus.COMPLETE;
import static umc.spring.misson5_homework.entity.mission.QMisson.misson;

@Repository
public class MissonRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Autowired
    public MissonRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }


    @Override
    public List<MissonDTO> getOngoingMissons(Pageable pageable) {

        QMission mission = QMission.mission;

        return queryFactory.select(Projections.fields(MissonDTO.class,
                        misson.point,
                        mission.status,
                        mission.content))
                .from(mission)
                .where(mission.status.eq(CHALLENGING))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public List<MissonDTO> getCompletedMissions(Pageable pageable) {
        QMission mission = QMission.mission;

        return queryFactory.select(Projections.fields(MissonDTO.class,
                        mission.point,
                        mission.status,
                        mission.content))
                .from(mission)
                .where(mission.status.eq(COMPLETE))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }
}
