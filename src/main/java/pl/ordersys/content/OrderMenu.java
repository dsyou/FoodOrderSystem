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

    private LinkedList<Cuisines> arrayOfCuisine = null; // List of Cuisine
    private LinkedList<Drinks> arrayOfDrinks = null; //  List of Drinks

    private boolean menuCheck;
    public volatile int userKey = 0;
    public int t = 0;

    public static OrderMenu getInstance() {
        if (instance == null) {
            instance = new OrderMenu();
        }
        return instance;
    }

}
