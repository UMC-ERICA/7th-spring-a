package UMC.spring.web.dto.storeDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class CreateStoreDTO {
        @NotBlank
        @Size(max = 20)
        private String name;
        @NotBlank
        @Size(min = 3)
        private String storeAddress;
        @NotBlank
        private String storeCategory;
        @NotBlank
        @Size(min=2)
        private String city;
        @NotBlank
        @Size(min=2)
        private String district;
        @NotBlank
        @Size(min=2)
        private String neighborhood;

    }
}
