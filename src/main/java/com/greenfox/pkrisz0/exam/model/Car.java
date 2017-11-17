package com.greenfox.pkrisz0.exam.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lincencePlates")
public class Car {
    @Id
    String plate;

    String carBrand;
    String carModel;
    String color;
    int year;

    public Car() {
    }

    public Car(String plate, String carBrand, String carModel, String color, int year) {
        this.plate = plate;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.color = color;
        this.year = year;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
