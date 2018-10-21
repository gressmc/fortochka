package com.gress.fortochka.controllers;

import com.gress.fortochka.services.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Roman_Radetskiy.
 */
@Controller
public class MemberController {

    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("/members")
    public String getKinderGartens(Model model){
        model.addAttribute("members", memberService.findAll());
        return "members";
    }
}
