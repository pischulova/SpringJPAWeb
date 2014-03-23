package com.mysite.entity;

import javax.persistence.*;

/**
 * Created by Алена on 16.03.14.
 */
@Entity
@Table
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int personId;

    @Column(unique = true)
    String name;

    @ManyToOne
    @JoinColumn(name="addressId")
    private Address address;

    public Person(int personId, String name) {
        this.personId = personId;
        this.name = name;
    }

    public Person() {
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (address!=null)
            return "Person{" +
                    "personId=" + personId +
                    ", name='" + name + '\'' +
                    ", address=" + address.toString() +
                    '}';
        else
            return "Person{" +
                    "personId=" + personId +
                    ", name='" + name + '\'' +
                    ", address=null";
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {


        this.address = address;
    }
}
