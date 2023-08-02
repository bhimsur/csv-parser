package io.bhimsur.csv;

import com.opencsv.bean.CsvBindByName;

public class Car {
    @CsvBindByName
    private String model;
    @CsvBindByName
    private int year;
    @CsvBindByName(column = "seat")
    private int seatCount;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public Car(String model, int year, int seatCount) {
        this.model = model;
        this.year = year;
        this.seatCount = seatCount;
    }

    public Car() {
    }
}
