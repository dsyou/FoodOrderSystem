package pl.ordersys.core;


import lombok.*;

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
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Order {

    private static Order instance;

    private List<String> namesOfOrderedItems;
    private List<Double> priceOfOrderedItems;

    private List<Double> tmp; // Temporary Price List

    public int quantity = 0;
    private Double totalAmount = 0.d;

    private volatile Boolean lemon;
    private volatile Boolean ice;

    /**
     * If the order has been executed
     * List of orderedItems and price should be overwritten
     */
    public void dropOrder() {
        this.namesOfOrderedItems = new ArrayList<>(); //.forEach(s ->s = "");
        this.priceOfOrderedItems = new ArrayList<>();//.forEach(i ->i =0.d);
        this.quantity = 0;
        this.totalAmount = 0.d;
    }

    public static Order getInstance() {
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
        tmp = new ArrayList<>(); //Tmp list is clearing here
    }

}
