package com.greenfox.pkrisz0.exam.controller;


import com.greenfox.pkrisz0.exam.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    @Autowired
    CarRepo carRepo;
}
