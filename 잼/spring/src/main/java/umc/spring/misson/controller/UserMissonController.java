package umc.spring.misson.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.misson.annotation.custom.CustomPage;
import umc.spring.misson.dto.user.UserMissonFindDto;
import umc.spring.misson.service.userMisson.UserMissonQueryService;

@RestController
@RequestMapping("/api/user-missions")
@RequiredArgsConstructor
@Slf4j
public class UserMissonController {

    private final UserMissonQueryService userMissonQueryService;

    @Operation(summary = "내가 진행중인 미션 목록 조회", description = "진행 중인 미션 목록을 페이지네이션하여 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "진행 중인 미션 목록 조회 성공", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserMissonFindDto.class)))),
            @ApiResponse(responseCode = "400", description = "잘못된 페이지 번호", content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<Page<UserMissonFindDto>> getInProgressMissons (
            @RequestParam(name = "page") @CustomPage Integer page) {
        Page<UserMissonFindDto> inProgressMissions = userMissonQueryService.getInProgressMissions(page);
        return ResponseEntity.ok(inProgressMissions);

    }
}
