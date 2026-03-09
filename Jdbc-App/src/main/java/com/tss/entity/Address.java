package com.tss.entity;

public class Address {

    private int addressId;
    private int studentId;
    private String city;
    private String state;
    private String pincode;

    public Address(int studentId, String city, String state, String pincode) {
        this.studentId = studentId;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public Address(int addressId, int studentId, String city, String state, String pincode) {
        this.addressId = addressId;
        this.studentId = studentId;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", studentId=" + studentId +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}