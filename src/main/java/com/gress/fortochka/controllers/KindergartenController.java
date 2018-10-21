package com.gress.fortochka.controllers;

import com.gress.fortochka.services.KindergartenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Roman_Radetskiy.
 */
@Controller
public class KindergartenController {

    KindergartenService kindergartenService;

    public KindergartenController(KindergartenService kindergartenService) {
        this.kindergartenService = kindergartenService;
    }

    @RequestMapping("/kindergartens")
    public String getKinderGartens(Model model){
        model.addAttribute("kindergartens", kindergartenService.findAll());
        return "kindergartens";
    }
}
