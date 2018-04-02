package pl.ordersys.content;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;

/**
 * This class contains representations of the object Order Menu.
 * This object contains list of available Cuisine/dishes and drinks.
 * Object of this class is implement as singleton design pattern.
 *
 * @author Dawid Janik
 */

@Getter
@Setter
@NoArgsConstructor
public class OrderMenu {

    private static OrderMenu instance = null;

    private LinkedList<Cuisines> cuisines = null; // List of Cuisine
    private LinkedList<Drinks> drinks = null; //  List of Drinks

    private boolean menuCheck;
    public volatile int userKey = 0;
    public int t = 0; //todo what is that ?

    public static OrderMenu getInstance() {
        if (instance == null) {
            instance = new OrderMenu();
        }
        return instance;
    }

    public static void getDrinksNames() {
        for (int i = 0; i < getInstance().getDrinks().size(); i++) {
            System.out.println("" + (i + 1) + "." + getInstance().getDrinks().get(i).getName());
        }
    }

    public static void showCuisinesNames() {
        for (int i = 0; i < getInstance().getCuisines().size(); i++) {
            System.out.println("" + (i + 1) + "." + getInstance().getCuisines().get(i).getNameCuisines());
        }
    }

    public static String getDrinkPrice() {
        return getInstance().getDrinks().get(getInstance().userKey - 1).getPrice() + "$";
    }

    public static String getDrinkName() {
        return getInstance().getDrinks().get(getInstance().userKey - 1).getName();
    }

    public static Double getPrice() {
        return getInstance().getCuisines().get(getInstance().userKey - 1).getPrice();
    }

    public static String getNameDessert() {
        return getInstance().getCuisines().get(getInstance().userKey  - 1 ).getNameDessert();
    }

    public static String getNameMainCourse() {
        return getInstance().getCuisines().get(getInstance().userKey - 1 ).getNameMainCourse();
    }

}
