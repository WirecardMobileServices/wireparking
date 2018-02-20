package com.example.wire.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PARKING_PLACE")
public class ParkingPlace {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(name = "DISPLAY_NAME")
    private String displayName;

    @NotNull
    @Size(max = 100)
    @Column(name = "LOGIN_ALIAS")
    private String loginAlias;

    @ManyToOne
    @JoinColumn(name = "PARKING_HOUSE_ID")
    private ParkingHouse parkingHouse;


    public ParkingPlace() {
    }

    public ParkingPlace(String displayName, String loginAlias) {
        this.displayName = displayName;
        this.loginAlias = loginAlias;
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

    public String getLoginAlias() {
        return loginAlias;
    }

    public void setLoginAlias(String loginAlias) {
        this.loginAlias = loginAlias;
    }

    public ParkingHouse getParkingHouse() {
        return parkingHouse;
    }

    public void setParkingHouse(ParkingHouse parkingHouse) {
        this.parkingHouse = parkingHouse;
    }

    @Override
    public String toString() {
        return "ParkingPlace{" +
                "id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                ", loginAlias='" + loginAlias + '\'' +
                ", parkingHouse=" + parkingHouse +
                '}';
    }
}
