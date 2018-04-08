package pl.ordersys.view;

import org.springframework.stereotype.Component;

import static pl.ordersys.core.content.OrderMenu.*;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric values responsible to
 * specific action assigned to this value (e.g 0. Cancel action)
 * <p>
 * This class responds to sout Launch's order content.
 *
 * @author Dawid Janik
 */
@Component
public class LunchView extends CliView {

    public void view() {
        UtilityView.viewSystemInfo();

        showCuisinesNames();
        UtilityView.totalAmount();
        UtilityView.backToTop();

//        getEngine().makeActionLaunchView();
        getEngine().makeActionLaunchView();
    }

    public void viewCuisinesContent() {
        UtilityView.viewSystemInfo();

        System.out.println("Main course: " + getNameMainCourse());
        System.out.println("Dessert: " + getNameDessert());
        System.out.println("Price:" + getPrice());
        System.out.println();
        System.out.println("5.Order");

        UtilityView.backToTop();
        getEngine().makeOrderView();
    }

}

