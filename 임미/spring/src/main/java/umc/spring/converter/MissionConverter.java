package umc.spring.converter;

import umc.spring.domain.mission.Mission;
import umc.spring.domain.store.Store;
import umc.spring.web.dto.MissionDTO;

public class MissionConverter {

    public static Mission toMission(MissionDTO.MissionRequestDTO request, Store storeById){

        return Mission.builder()
                .content(request.getContent())
                .point(request.getPoint())
                .status(Boolean.FALSE)
                .deadline(request.getDeadLine())
                .store(storeById)
                .build();

    }
}
