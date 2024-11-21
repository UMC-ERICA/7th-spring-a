package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.AddressConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.member.Address;
import umc.spring.domain.store.Store;
import umc.spring.repository.AddressRepository;
import umc.spring.repository.storeRepository.StoreRepository;
import umc.spring.web.dto.StoreDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final AddressRepository addressRepository;

    @Override
    public StoreDTO.StoreSaveResponseDTO save(StoreDTO.StoreSaveRequestDTO request) {

        Store newStore = StoreConverter.toStore(request);

        Address newAddress = AddressConverter.toAddress(request,newStore);

        newStore.setAddress(newAddress);

        addressRepository.save(newAddress);

        storeRepository.save(newStore);

        return StoreDTO.StoreSaveResponseDTO.builder()
                .id(newStore.getId())
                .build();


    }
}
