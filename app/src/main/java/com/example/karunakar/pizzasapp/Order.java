package com.example.karunakar.pizzasapp;

/**
 * Created by root on 9/8/17.
 */

public class Order {

    private String itemname;
    private String numofitems;
    private String custname;
    private String custphn;

    public Order() {
    }

    public Order(String itemname, String numofitems, String custname, String custphn) {
        this.itemname = itemname;
        this.numofitems = numofitems;
        this.custname = custname;
        this.custphn = custphn;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getNumofitems() {
        return numofitems;
    }

    public void setNumofitems(String numofitems) {
        this.numofitems = numofitems;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCustphn() {
        return custphn;
    }

    public void setCustphn(String custphn) {
        this.custphn = custphn;
    }
}
