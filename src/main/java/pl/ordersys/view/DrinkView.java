package pl.ordersys.view;

import pl.ordersys.content.OrderMenu;
import pl.ordersys.core.Engine;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric values responsible to
 * specific action assigned to this value (e.g 0. Cancel action)
 *
 * This class responds to sout drink's order content.
 *
 * @author Dawid Janik
 */
public class DrinkView {

    public DrinkView() {
        super();
    }

    private static OrderMenu o = OrderMenu.getInstance();

    public static void view(){

        CommonPurposeView.viewSystemInfo();

        for (int i = 0; i < o.getArrayOfDrinks().size(); i++) {
            System.out.println("" + (i + 1) + "." + o.getArrayOfDrinks().get(i).getName() );
            //+ " $" + o.getArrayOfDrinks().get(i).getPrice()
        }
        CommonPurposeView.totalAmount();
        CommonPurposeView.backToTop();

        Engine.makeActionDrinkView();
    }

    //ice cubes or/and lemon
    public static void viewDrinksContent() {
        CommonPurposeView.viewSystemInfo();

        System.out.println("Drink name: " + o.getArrayOfDrinks().get(o.userKey - 1 ).getName());

        System.out.println("Price:" + o.getArrayOfDrinks().get(o.userKey - 1).getPrice() + "$");
        System.out.println();
        System.out.println("5.Order");

        CommonPurposeView.backToTop();
        Engine.makeOrderView();
    }

}
