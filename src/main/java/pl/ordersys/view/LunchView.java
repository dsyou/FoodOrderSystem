package pl.ordersys.view;

import lombok.experimental.UtilityClass;
import pl.ordersys.content.OrderMenu;
import pl.ordersys.core.Engine;

import static pl.ordersys.content.OrderMenu.*;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric values responsible to
 * specific action assigned to this value (e.g 0. Cancel action)
 *
 * This class responds to sout Launch's order content.
 *
 * @author Dawid Janik
 */
@UtilityClass
public class LunchView {

    public static void view() {
        CommonPurposeView.viewSystemInfo();

        showCuisinesNames();

        CommonPurposeView.totalAmount();
        CommonPurposeView.backToTop();

        Engine.makeActionLaunchView();
    }

    public static void viewCuisinesContent() {
        CommonPurposeView.viewSystemInfo();

        System.out.println("Main course: " + getNameMainCourse());
        System.out.println("Dessert: " + getNameDessert());
        System.out.println("Price:" + getPrice());
        System.out.println();
        System.out.println("5.Order");

        CommonPurposeView.backToTop();
        Engine.makeOrderView();
    }

}

