package com.gress.fortochka.controllers;

import com.gress.fortochka.services.KindergartenService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Roman_Radetskiy.
 */
@Controller
public class MainController {

    KindergartenService kindergartenService;

    public MainController(KindergartenService kindergartenService) {
        this.kindergartenService = kindergartenService;
    }

    @RequestMapping(value = {"/", "/backoffice"}, method = RequestMethod.GET)
    public String index(){
        return "main";
    }

    @RequestMapping(value = "/adm", method = RequestMethod.GET)
    public String autorisation(){
        return "login";
    }

    @RequestMapping(value = "/backoffice", method = RequestMethod.POST)
    public String adminConsole(){
        return "backoffice";
    }

}
