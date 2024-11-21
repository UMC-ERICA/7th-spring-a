package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.domain.member.Member;
import umc.spring.domain.store.Store;
import umc.spring.web.dto.ReviewDTO;

public class ReviewConverter {

    public static Review toReview(ReviewDTO.ReviewSaveRequestDTO request, Member memberById, Store storeById) {
        return Review.builder()
                .content(request.getContent())
                .score(request.getScore())
                .member(memberById)
                .store(storeById)
                .build();
    }
}
