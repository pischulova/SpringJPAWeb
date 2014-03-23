package com.mysite.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Алена on 16.03.14.
 */
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    private String city;

    @OneToMany(mappedBy="address")
    private Collection<Person> persons;

    public Address(String city) {
        this.city = city;
    }

    public Address() {}

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                '}';
    }
}
