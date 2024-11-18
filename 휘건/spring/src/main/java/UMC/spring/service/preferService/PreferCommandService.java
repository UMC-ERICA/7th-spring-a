package UMC.spring.service.preferService;

import java.util.List;

public interface PreferCommandService {

    Boolean areCategoriesExist(List<Long> categoryIds);
}
