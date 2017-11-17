package com.greenfox.pkrisz0.exam.model;

import java.util.List;

public class ReturnObject {
    String result;
    List<Car> data;

    public ReturnObject() {
    }

    public ReturnObject(List<Car> data, String result) {
        this.result = result;
        this.data = data;

    }

    public List<Car> getData() {
        return data;
    }

    public void setData(List<Car> data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
