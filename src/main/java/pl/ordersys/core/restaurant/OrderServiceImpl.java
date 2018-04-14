package pl.ordersys.core.restaurant;


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
public class OrderServiceImpl implements OrderService {

    private List<String> namesOfOrderedItems;
    private List<Double> priceOfOrderedItems;

    private List<Double> tmpPrice; // Temporary Price List

    private int quantity = 0;
    private Double totalAmount = 0.d;

    private volatile Boolean lemon;
    private volatile Boolean ice;

    @Override
    public void makeOrder() {

    }

    /**
     * If the order has been executed
     * List of orderedItems and price should be overwritten
     */
    @Override
    public void dropOrder() {
        this.namesOfOrderedItems = new ArrayList<>();
        this.priceOfOrderedItems = new ArrayList<>();
        this.quantity = 0;
        this.totalAmount = 0.d;
    }

//    public static Order getInstance() {
//        if (instance == null) {
//            instance = new Order();
//        }
//        return instance;
//    }
//
//    public void totalAmount() {
//        Double totalAmount = 0.d;
//        for (Double oneItemPrice : tmpPrice) {
//            totalAmount += oneItemPrice;
//        }
//        this.totalAmount += totalAmount;
//        System.out.println(this.totalAmount);
//        tmpPrice = new ArrayList<>(); //Tmp list is clearing here
//    }
//
//    public static void getOrderedItems() {
//        for (int i = 0; i < getInstance().getNamesOfOrderedItems().size(); i++) {
//            System.out.println((i + 1) + "." + "  Name: " + getInstance().getNamesOfOrderedItems().get(i)
//                    + " Price: " + getInstance().getPriceOfOrderedItems().get(i) + "$");
//        }
//    }


}
