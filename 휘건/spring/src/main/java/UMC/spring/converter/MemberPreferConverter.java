package UMC.spring.converter;

import UMC.spring.domain.Prefer;
import UMC.spring.domain.mapping.MemberPrefer;

import java.util.List;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<Prefer> foodCategoryList) {

        return foodCategoryList.stream()
                .map(prefer ->
                        MemberPrefer.builder()
                                .prefer(prefer)
                                .build()).toList();
    }
}
