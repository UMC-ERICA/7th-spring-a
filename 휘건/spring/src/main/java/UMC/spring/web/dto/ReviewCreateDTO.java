package UMC.spring.web.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ReviewCreateDTO {

    private Long memberId;
    private Long storeId;

    private String content;
    private BigDecimal rate;

}
