package UMC.spring.domain.enums;

import UMC.spring.api.code.status.ErrorStatus;
import UMC.spring.api.exception.handler.PreferHandler;
import lombok.Getter;

@Getter
public enum FoodCategory {
    한식,
    일식,
    중식,
    양식,
    치킨,
    분식,
    고기구이,
    도시락,
    야식,
    패스트푸드,
    디저트,
    아시안푸드;


    public static FoodCategory fromString(String value) {
        try {
            return FoodCategory.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new PreferHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND);
        }
    }
}
