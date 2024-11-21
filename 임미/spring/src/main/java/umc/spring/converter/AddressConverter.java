package umc.spring.converter;

import umc.spring.domain.member.Address;
import umc.spring.domain.store.Store;
import umc.spring.web.dto.StoreDTO;

public class AddressConverter {

    public static Address toAddress(StoreDTO.StoreSaveRequestDTO request, Store newStore){

        return Address.builder()
                .province(request.getProvince())
                .city(request.getCity())
                .town(request.getTown())
                .details(request.getDetail())
                .store(newStore)
                .build();
    }
}
