package com.gress.fortochka.controllers;

import com.gress.fortochka.services.KinderGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Roman_Radetskiy.
 */
@Controller
public class KinderGroupController {

    KinderGroupService kinderGroupService;

    public KinderGroupController(KinderGroupService kinderGroupService) {
        this.kinderGroupService = kinderGroupService;
    }

    @RequestMapping("/kindergroups")
    public String getGroups(Model model){
        model.addAttribute("kindergroups", kinderGroupService.findAll());
        return "kindergroups";
    }
}
