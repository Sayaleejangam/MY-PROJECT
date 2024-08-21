package com.jspiders.cardekho.Response;

import java.util.List;

import com.jspiders.cardekho.Pojo.Car;

public class ResponseStructure<T> {
  
    private String message;
    private T data;
    private int status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    // Method to set a single car
    public void setData(Car car) {
        this.data = (T) car;
    }

    // Method to set a list of cars
    public void setDatas(List<Car> cars) {
        this.data = (T) cars;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
