package pl.ordersys.view;

import lombok.experimental.UtilityClass;
import pl.ordersys.content.OrderMenu;
import pl.ordersys.core.Engine;

import static pl.ordersys.content.OrderMenu.getDrinkName;
import static pl.ordersys.content.OrderMenu.getDrinkPrice;
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
@UtilityClass
public class DrinkView {

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

        System.out.println("Drink name: " + getDrinkName());

        System.out.println("Price:" + getDrinkPrice());
        System.out.println();
        System.out.println("5.Order");

        CommonPurposeView.backToTop();
        Engine.makeOrderView();
    }

}
