package pl.ordersys.view;

import pl.ordersys.content.OrderMenu;
import pl.ordersys.core.Engine;

import static pl.ordersys.content.OrderMenu.getDrinksNames;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric values responsible to
 * specific action assigned to this value (e.g 0. Cancel action)
 * <p>
 * This class responds to sout drink's order content.
 *
 * @author Dawid Janik
 */
public class DrinkView {

    public DrinkView() {
        super();
    }

    private static OrderMenu orderMenu = OrderMenu.getInstance();

    public static void view() {
        CommonPurposeView.viewSystemInfo();

        getDrinksNames();
        CommonPurposeView.totalAmount();
        CommonPurposeView.backToTop();

        Engine.makeActionDrinkView();
    }

    //ice cubes or/and lemon
    public static void viewDrinksContent() {
        CommonPurposeView.viewSystemInfo();

        System.out.println("Drink name: " + orderMenu.getDrinks().get(orderMenu.userKey - 1).getName());

        System.out.println("Price:" + orderMenu.getDrinks().get(orderMenu.userKey - 1).getPrice() + "$");
        System.out.println();
        System.out.println("5.Order");

        CommonPurposeView.backToTop();
        Engine.makeOrderView();
    }

}
