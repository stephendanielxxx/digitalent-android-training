package com.example.digitalenttraining.model;

public class OfficeModel {
    private String name;
    private String address;
    private int employee;
    private double latitude;
    private double longitude;

    public OfficeModel(String name, String address, int employee, double latitude, double longitude) {
        this.name = name;
        this.address = address;
        this.employee = employee;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
