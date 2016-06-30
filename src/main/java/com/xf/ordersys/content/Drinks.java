package com.xf.ordersys.content;

/**
 * Created by Dawid Janik on 2016-06-27.
 *
 *
 */

public class Drinks {

    private String name = "";
    private int price;


//===================================================================
    //
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Drinks(int price, String name) {
        this.price = price;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Drinks{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
