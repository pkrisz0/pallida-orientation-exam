package com.greenfox.pkrisz0.exam.repository;

import com.greenfox.pkrisz0.exam.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepo extends CrudRepository<Car,String> {
}
