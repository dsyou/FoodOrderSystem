package com.xf.ordersys.content;

/**
 * This class contains representations of the each object "Drinks"
 *
 * @author Dawid Janik
 */
public class Drinks {

    private String name = "";
    private double price = 0;

    public Drinks() {
    }

    public Drinks(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
