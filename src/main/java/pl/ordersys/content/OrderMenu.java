package pl.ordersys.content;

import java.util.LinkedList;

/**
 * This class contains representations of the object Order Menu.
 * This object contains list of available Cuisine/dishes and drinks.
 * Object of this class is implement as singleton design pattern.
 *
 *@author Dawid Janik
 */
public class OrderMenu {

    private static OrderMenu instance = null;

    private LinkedList<Cuisines> arrayOfCuisine = null; // List of Cuisine
    private LinkedList<Drinks>   arrayOfDrinks = null; //  List of Drinks

    public volatile int userKey = 0;
    public int t = 0;

    private boolean menuCheck;

    public static OrderMenu getInstance() {
        return instance;
    }

    public static void setInstance(OrderMenu instance) {
        OrderMenu.instance = instance;
    }

    public LinkedList<Cuisines> getArrayOfCuisine() {
        return arrayOfCuisine;
    }

    public void setArrayOfCuisine(LinkedList<Cuisines> arrayOfCuisine) {
        this.arrayOfCuisine = arrayOfCuisine;
    }

    public LinkedList<Drinks> getArrayOfDrinks() {
        return arrayOfDrinks;
    }

    public void setArrayOfDrinks(LinkedList<Drinks> arrayOfDrinks) {
        this.arrayOfDrinks = arrayOfDrinks;
    }

    public void setMenuCheck(boolean menuCheck) {
        this.menuCheck = menuCheck;
    }

    public boolean isMenuCheck() {
        return menuCheck;
    }

    public static OrderMenu getInstace(){
        if (instance==null){
            instance= new OrderMenu();
        }
        return instance;
    }

}
