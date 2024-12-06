package UMC.spring.web.controller;

import UMC.spring.service.memberService.MemberCommandService;
import UMC.spring.web.dto.memberDTO.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberViewController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/signup")
    public String joinMember(@ModelAttribute("memberJoinDto") MemberRequestDTO.JoinDTO request,
                             BindingResult bindingResult, Model model) {
        System.out.println("요청 데이터: " + request);

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println("유효성 검증 에러: " + error.getDefaultMessage());
            });
            return "signup";
        }


        try {
            memberCommandService.joinMember(request);
            return "redirect:/login";
        } catch (Exception e) {
            System.out.println("회원가입 실패: " + e.getMessage());
            model.addAttribute("error", e.getMessage());
            return "signup";
        }
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("memberJoinDto", new MemberRequestDTO.JoinDTO());
        return "signup";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}