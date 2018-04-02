package pl.ordersys.view;

import pl.ordersys.content.OrderMenu;
import pl.ordersys.core.Engine;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric values responsible to
 * specific action assigned to this value (e.g 0. Cancel action)
 *
 * This class responds to sout Launch's order content.
 *
 * @author Dawid Janik
 */
public class LunchView {

    public LunchView() {
        super();
    }

    private static OrderMenu orderMenu = OrderMenu.getInstance();

    public static void view() {
        CommonPurposeView.viewSystemInfo();

        for (int i = 0; i < orderMenu.getArrayOfCuisine().size(); i++) {
            System.out.println("" + (i + 1) + "." + orderMenu.getArrayOfCuisine().get(i).getNameCuisines());
        }

        CommonPurposeView.totalAmount();
        CommonPurposeView.backToTop();

        Engine.makeActionLaunchView();
    }

    public static void viewCuisinesContent() {
        CommonPurposeView.viewSystemInfo();

        System.out.println("Main course: " + orderMenu.getArrayOfCuisine().get(orderMenu.userKey - 1 ).getNameMainCourse());
        System.out.println("Dessert: " + orderMenu.getArrayOfCuisine().get(orderMenu.userKey  - 1 ).getNameDessert());
        System.out.println("Price:" + orderMenu.getArrayOfCuisine().get(orderMenu.userKey - 1).getPrice());
        System.out.println();
        System.out.println("5.Order");

        CommonPurposeView.backToTop();
        Engine.makeOrderView();
    }

}

