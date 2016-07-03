package com.xf.ordersys.core;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dawid Janik on 2016-06-28.
 *
 *
 *
 */
public  class Order {


    private static Order instance;

    private List<String>  namesOfOrderedItems; // Uwaga Null
    private List<Double>  priceOfOrderedItems;

    private List<Double>  tmp; // Temporary Price List

    public int quantity = 0;
    private Double totalAmount = 0.d;

//===================================================================
// Order()

    public Order(){
        namesOfOrderedItems = new ArrayList<String>();
        priceOfOrderedItems = new ArrayList<Double>();

        tmp = new ArrayList<Double>();
    }


    public Order(ArrayList<String> namesOfOrderedItems, ArrayList<Double> totalPrice) {
        this.namesOfOrderedItems = namesOfOrderedItems;
        this.priceOfOrderedItems = totalPrice;
    }

    /*

     */
    public  void dropOrder(){
        this.namesOfOrderedItems = new ArrayList<String>(); //.forEach(s ->s = ""); // vs new list ??
        this.priceOfOrderedItems = new ArrayList<Double>();//.forEach(i ->i =0.d);
        quantity = 0;
        totalAmount = 0.d;
    }

//=================================================================================================================
//Method Singleton

    public static Order getInstace() {

        if (instance == null) {

            instance = new Order();

        }
        return instance;
    }


//===================================================================
// Order()

    public void totalAmount(){
         Double t = 0.d;
         for (Double l: tmp){ //priceOfOrderedItems
            t += l;
         }
        this.totalAmount += t;
        System.out.println( this.totalAmount );
        tmp = new ArrayList<Double>(); //Tmp list czyszczona tutaj

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

    //===================================================================
// toString()

    @Override
    public String toString() {
        return "Order{" +
                "namesOfOrderedItems=" + namesOfOrderedItems +
                ", priceOfOrderedItems=" + priceOfOrderedItems +
                ", quantity=" + quantity +
                ", totalAmount=" + totalAmount +
                '}';
    }
}// End of Order
