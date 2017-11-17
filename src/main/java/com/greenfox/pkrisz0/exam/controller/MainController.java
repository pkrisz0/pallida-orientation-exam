package com.greenfox.pkrisz0.exam.controller;

import com.greenfox.pkrisz0.exam.repository.CarRepo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    Boolean diplomat;

    @Autowired
    CarRepo carRepo;

//    @GetMapping({"","/"})
//    public String main(Model model, @RequestParam(required = false) String search){
//
//        if (search != null && search.matches("^.*[^a-zA-Z0-9-].*$") && search.length() <= 7){
//            model.addAttribute("error", "Sorry, the submitted license plate is not valid.");
//        } else if (search != null){
//            model.addAttribute("cars", carRepo.findAllByPlateIsLike("%" + search + "%"));
//        } else {
//            model.addAttribute("cars", carRepo.findAll());
//        }
//        return "main";
//    }

    @GetMapping({"","/"})
    public String mainTwo(Model model, @RequestParam(required = false) String search){

        if (search != null && search.matches("^.*[^a-zA-Z0-9-].*$") && search.length() <= 7 ){
            model.addAttribute("error", "Sorry, the submitted license plate is not valid.");
        } else if (search != null && diplomat==null || search != null && diplomat==false){
            model.addAttribute("cars", carRepo.findAllByPlateIsLike("%" + search + "%"));
        } else if (search != null && diplomat==true) {
            model.addAttribute("cars", carRepo.findAllByPlateStartingWithAndPlateContains("DT", search));
            diplomat = false;
        } else {
            model.addAttribute("cars", carRepo.findAll());
        }
        return "main";
    }

    @GetMapping("/diplomatT")
    public String diplomatT(){
        diplomat = true;
        return "redirect:/";
    }

    @GetMapping("/diplomat")
    public String diplomat(Model model, @RequestParam(required = false) String search){
        model.addAttribute("cars", carRepo.findAllByPlateIsLikeAndPlateStartingWith("%" + search + "%", "DT"));
        return "main";
    }

    @GetMapping("/police")
    public String police(Model model){
        model.addAttribute("cars", carRepo.findAllByPlateStartingWith("RB"));
        return "main";
    }

    @GetMapping("/{brand}")
    public String filter(Model model, @PathVariable String brand){
        model.addAttribute("cars", carRepo.findAllByCarBrand(brand));
        return "main";
    }
}
