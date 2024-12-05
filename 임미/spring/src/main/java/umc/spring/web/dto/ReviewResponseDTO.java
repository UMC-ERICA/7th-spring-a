package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.ReviewComment;

import java.time.LocalDate;
import java.util.List;

public class ReviewResponseDTO {

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class MyReviewResponseDTO{

        String nickname;

        Integer score;

        String content;

        LocalDate createdAt;

        List<CommentResponseDTO.MyReviewCommentResponseDTO> reviewComments;

        List<String> reviewImagePath;
    }





}
