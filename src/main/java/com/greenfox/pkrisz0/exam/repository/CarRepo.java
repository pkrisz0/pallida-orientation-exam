package com.greenfox.pkrisz0.exam.repository;

import com.greenfox.pkrisz0.exam.model.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepo extends CrudRepository<Car,String> {
    List<Car> findAllByPlateIsLike(String plate);
    List<Car> findAllByCarBrand(String brand);
    List<Car> findAllByPlateIsLikeAndPlateStartingWith(String plate, String starts);
}
