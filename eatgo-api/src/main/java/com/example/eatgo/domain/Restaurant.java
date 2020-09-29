package com.example.eatgo.domain;


import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;

    @Transient
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

//    public Restaurant(String name) {
//        this.name = name;


//    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public Restaurant(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Restaurant() {
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    public Long getId() {
        return id;
    }

    public Object getInformation() {
        return name +" in " + address;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }


    public void setMenuItem(List<MenuItem> menuItems) {
        for(MenuItem menuItem : menuItems){
            addMenuItem(menuItem);
        }
    }

    public void setId(long id) {
        this.id = id;
    }


    public void updateInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }
}