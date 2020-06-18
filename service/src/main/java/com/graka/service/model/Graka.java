package com.graka.service.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Graka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    @Size(max = 100)
    @Column
    private String Name;

    @Column(name = "Manufacture")
    private Enum<Manufacturer> ManufacturerEnum;

    @Column
    private double Price;

    public Graka() {
    }

    public Graka(String Name,Enum<Manufacturer> ManufacturerEnum,double Price) {
        this.Name = Name;
        this.ManufacturerEnum = ManufacturerEnum;
        this.Price = Price;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Enum<Manufacturer> getManufacturerEnum() {
        return ManufacturerEnum;
    }

    public void setManufacturerEnum(Enum<Manufacturer> manufacturerEnum) {
        ManufacturerEnum = manufacturerEnum;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
