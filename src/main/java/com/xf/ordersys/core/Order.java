package com.xf.ordersys.core;


import java.util.ArrayList;
import java.util.List;

/**
 * This class contains representations of the each order placed
 * by user actions.
 * Object of this class is immutable during the executed order
 * singleton design.
 *
 * @author Dawid Janik
 */
public class Order {


    private static Order instance;

    private List<String> namesOfOrderedItems;
    private List<Double> priceOfOrderedItems;

    private List<Double> tmp; // Temporary Price List

    public int quantity = 0;
    private Double totalAmount = 0.d;

    private volatile Boolean lemon;
    private volatile Boolean ice;

    public Order() {
        namesOfOrderedItems = new ArrayList<String>();
        priceOfOrderedItems = new ArrayList<Double>();
        lemon = false;
        ice = false;
        tmp = new ArrayList<Double>();
    }

    public Order(ArrayList<String> namesOfOrderedItems, ArrayList<Double> totalPrice) {
        this.namesOfOrderedItems = namesOfOrderedItems;
        this.priceOfOrderedItems = totalPrice;
    }

    /**
     * If the order has been executed
     * List of orderedItems and price should be overwritten
     */
    public void dropOrder() {
        this.namesOfOrderedItems = new ArrayList<String>(); //.forEach(s ->s = "");
        this.priceOfOrderedItems = new ArrayList<Double>();//.forEach(i ->i =0.d);
        quantity = 0;
        totalAmount = 0.d;
    }

    public static Order getInstace() {

        if (instance == null) {

            instance = new Order();

        }
        return instance;
    }

    public void totalAmount() {
        Double t = 0.d;
        for (Double l : tmp) { //priceOfOrderedItems
            t += l;
        }
        this.totalAmount += t;
        System.out.println(this.totalAmount);
        tmp = new ArrayList<Double>(); //Tmp list is clearing here

    }

    public List<String> getNamesOfOrderedItems() {
        return namesOfOrderedItems;
    }

    public void setNamesOfOrderedItems(List<String> namesOfOrderedItems) {
        this.namesOfOrderedItems = namesOfOrderedItems;
    }

    public List<Double> getPriceOfOrderedItems() {
        return priceOfOrderedItems;
    }

    public void setPriceOfOrderedItems(List<Double> priceOfOrderedItems) {
        this.priceOfOrderedItems = priceOfOrderedItems;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public List<Double> getTmp() {
        return tmp;
    }

    public Boolean getLemon() {
        return lemon;
    }

    public void setLemon(Boolean lemon) {
        this.lemon = lemon;
    }

    public Boolean getIce() {
        return ice;
    }

    public void setIce(Boolean ice) {
        this.ice = ice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "namesOfOrderedItems=" + namesOfOrderedItems +
                ", priceOfOrderedItems=" + priceOfOrderedItems +
                ", quantity=" + quantity +
                ", totalAmount=" + totalAmount +
                '}';
    }

}
