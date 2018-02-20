package com.example.wire.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PARKING_HOUSE")
public class ParkingHouse {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(max = 50)
    @Column(name = "DISPLAY_NAME")
    private String displayName;

    @NotNull
    @Column(name = "IAT")
    private double Iat;

    @NotNull
    @Column(name = "ION")
    private double Ion;

    @NotNull
    @Column(name = "STREET")
    private String street;

    @NotNull
    @Column(name = "CITY")
    private String city;

    @NotNull
    @Column(name = "ZIPCODE")
    private Integer zipCode;

    @OneToMany(mappedBy = "parkingHouse")
    List<ParkingPlace> parkingPlaceList;


    public ParkingHouse(){

    }

    public ParkingHouse(String displayName, double iat, double ion, String street, String city, Integer zipCode) {
        this.displayName = displayName;
        Iat = iat;
        Ion = ion;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public double getIat() {
        return Iat;
    }

    public void setIat(double iat) {
        Iat = iat;
    }

    public double getIon() {
        return Ion;
    }

    public void setIon(double ion) {
        Ion = ion;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public List<ParkingPlace> getParkingPlaceList() {
        return parkingPlaceList;
    }

    public void setParkingPlaceList(List<ParkingPlace> parkingPlaceList) {
        this.parkingPlaceList = parkingPlaceList;
    }

    public void add(ParkingPlace parkingPlace){

        if(parkingPlaceList == null){
            parkingPlaceList = new ArrayList<>();
        }
        parkingPlaceList.add(parkingPlace);
        parkingPlace.setParkingHouse(this);
    }

    @Override
    public String toString() {
        return "ParkingHouse{" +
                "id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                ", Iat=" + Iat +
                ", Ion=" + Ion +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
