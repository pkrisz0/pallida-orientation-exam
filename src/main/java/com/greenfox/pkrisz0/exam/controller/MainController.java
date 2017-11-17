package com.greenfox.pkrisz0.exam.controller;



import com.greenfox.pkrisz0.exam.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @Autowired
    CarRepo carRepo;

    @GetMapping({"","/"})
    public String main(Model model, @RequestParam(required = false) String search){

        if (search != null && search.matches("^.*[^a-zA-Z0-9 ].*$")){
            model.addAttribute("error", "Sorry, the submitted licence plate is not valid.");
        } else if (search != null){
            model.addAttribute("cars", carRepo.findAllByPlateIsLike("%" + search + "%"));
        } else {
            model.addAttribute("cars", carRepo.findAll());
        }
        return "main";
    }

    @GetMapping("/diplomat")
    public String diplomat(Model model){
        model.addAttribute("cars", carRepo.findAllByPlateStartingWith("DT"));
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
