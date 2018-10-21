package com.gress.fortochka.controllers;

import com.gress.fortochka.model.Member;
import com.gress.fortochka.model.Photo;
import org.apache.commons.lang3.StringUtils;
import com.gress.fortochka.services.PhotoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Roman_Radetskiy.
 */
@Controller
public class PhotoController {

    PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/photos")
    public String getPhotos(Model model) {
        List<Photo> photos = (List) photoService.findAll();
        Member member = photos.get(0).getMember();
        model.addAttribute("photos", photos);
        model.addAttribute("member", member);
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
}