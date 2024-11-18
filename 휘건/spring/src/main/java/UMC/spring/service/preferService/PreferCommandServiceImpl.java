package UMC.spring.service.preferService;


import UMC.spring.repository.preferRepository.PreferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PreferCommandServiceImpl implements PreferCommandService {

    private PreferRepository preferRepository;

    @Override
    public Boolean areCategoriesExist(List<Long> categoryIds) {
        return categoryIds.stream().allMatch(preferRepository::existsById);
    }
}
