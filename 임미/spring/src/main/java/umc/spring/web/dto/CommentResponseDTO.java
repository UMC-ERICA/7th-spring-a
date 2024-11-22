package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.ReviewComment;

import java.time.LocalDate;
import java.util.List;

public class CommentResponseDTO {

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class MyReviewCommentResponseDTO{

        String comment;

        LocalDate createdAt;
    }
}
