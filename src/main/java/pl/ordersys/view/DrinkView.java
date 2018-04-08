package pl.ordersys.view;

import pl.ordersys.core.Engine;

import static pl.ordersys.core.content.OrderMenu.getDrinkName;
import static pl.ordersys.core.content.OrderMenu.getDrinkPrice;
import static pl.ordersys.core.content.OrderMenu.getDrinksNames;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric values responsible to
 * specific action assigned to this value (e.g 0. Cancel action)
 * <p>
 * This class responds to sout drink's order content.
 *
 * @author Dawid Janik
 */
public class DrinkView extends CliView {

    @Override
    public void view() {
        UtilityView.viewSystemInfo();

        getDrinksNames();
        UtilityView.totalAmount();
        UtilityView.backToTop();

        getEngine().makeActionDrinkView();
    }

    //ice cubes or/and lemon
    public void viewDrinksContent() {
        UtilityView.viewSystemInfo();

        System.out.println("Drink name: " + getDrinkName());

        System.out.println("Price:" + getDrinkPrice());
        System.out.println();
        System.out.println("5.Order");

        UtilityView.backToTop();
        getEngine().makeOrderView();
    }


}


