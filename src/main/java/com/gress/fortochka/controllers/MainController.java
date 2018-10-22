package com.gress.fortochka.controllers;

import com.gress.fortochka.model.Kindergarten;
import com.gress.fortochka.model.Kindergroup;
import com.gress.fortochka.model.Member;
import com.gress.fortochka.model.Photo;
import com.gress.fortochka.services.KinderGroupService;
import com.gress.fortochka.services.KindergartenService;
import com.gress.fortochka.services.MemberService;
import com.gress.fortochka.services.PhotoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Roman_Radetskiy.
 */
@Controller
public class MainController {

    private KindergartenService kindergartenService;
    private KinderGroupService kinderGroupService;
    private PhotoService photoService;
    private MemberService memberService;

    public MainController(KindergartenService kindergartenService, KinderGroupService kinderGroupService, PhotoService photoService, MemberService memberService) {
        this.kindergartenService = kindergartenService;
        this.kinderGroupService = kinderGroupService;
        this.photoService = photoService;
        this.memberService = memberService;
    }

    @RequestMapping(value = "/adm", method = RequestMethod.GET)
    public String autorisation(){
        return "login";
    }

    @RequestMapping(value = "/backoffice", method = RequestMethod.POST)
    public String adminConsole(){
        return "backoffice";
    }

    @RequestMapping(value = {"/", "/backoffice"}, method = RequestMethod.GET)
    public String index(Model model){
        Collection<Kindergarten> kindergartens = (Collection<Kindergarten>) kindergartenService.findAll();
        model.addAttribute("kindergartens", kindergartens);
        return "main";
    }

    @RequestMapping("/kindergroup/{title}")
    public String getGroups(@PathVariable("title") String title, Model model){
        Kindergroup kindergroup = kinderGroupService.getItemByProp(title);
        model.addAttribute("kindergroup", kindergroup);
        return "kindergroup";
    }

    @PostMapping("/kindergarten/add")
    public String addKindergarten(@RequestParam("title") String title,
                                  @RequestParam("groups") String[] groups,
                                  Model model){
        Kindergarten kindergarten = kindergartenService.create(title, groups);
        model.addAttribute("kindergarten", kindergarten);
        return "kindergroup";
    }

    @RequestMapping("/photos")
    public String getPhotos(Model model) {
        List<Photo> photos = (List) photoService.findAll();
        model.addAttribute("photos", photos);

        if (!CollectionUtils.isEmpty(photos)){
            Member member = photos.get(0).getMember();
            model.addAttribute("member", member);
        }
        return "photos";
    }

    @RequestMapping("/photo/{code}")
    public String getPhotoByCode(@PathVariable("code") String code, Model model){
        Photo photo = photoService.getItemByProp(code);
        Member member = photo.getMember();
        model.addAttribute("photos", photo);
        model.addAttribute("member", member);
        return "photos";
    }

    @RequestMapping("/members")
    public String getKinderGartens(Model model){
        model.addAttribute("members", memberService.findAll());
        return "members";
    }

}
