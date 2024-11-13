package UMC.spring.web.dto.temp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TempResponse {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class TempTestDTO {
        String testString;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class TempExceptionDTO {
        Integer flag;
    }
}
