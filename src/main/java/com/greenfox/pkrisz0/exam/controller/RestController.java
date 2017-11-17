package com.greenfox.pkrisz0.exam.controller;

import com.greenfox.pkrisz0.exam.model.ReturnObject;
import com.greenfox.pkrisz0.exam.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    CarRepo carRepo;

    @GetMapping(value = "/api/search/{brand}")
    public ReturnObject getsMessageWithGet(@PathVariable String brand){
      return new ReturnObject(carRepo.findAllByCarBrand(brand),"ok");
    }
}
