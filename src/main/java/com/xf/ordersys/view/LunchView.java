package com.xf.ordersys.view;

import com.xf.ordersys.content.OrderMenu;
import com.xf.ordersys.core.Engine;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric value responsible to
 * specific action assigned to this value (e.g 0. Cancel action)
 *
 * This class responds to sout Launch's order content.
 *
 * @author Dawid Janik
 */
public class LunchView {

    public LunchView() {
        super();
    } //

    private static OrderMenu o = OrderMenu.getInstace();


//=================================================================================================================
// Methods

    public static void view() {

        CommonPurposeView.view_SystemInfo();

        for (int i = 0; i < o.getArrayOfCuisine().size(); i++) {
            System.out.println("" + (i + 1) + "." + o.getArrayOfCuisine().get(i).getName());
        }

        CommonPurposeView.totalAmount();
        CommonPurposeView.backToTop();

        Engine.makeAction_launchView();

    }

    public static void view_CuisinesContent() {

        CommonPurposeView.view_SystemInfo();

        System.out.println("Main course: " + o.getArrayOfCuisine().get(o.userKey - 1 ).getNameMainCourse());
        System.out.println("Dessert: " + o.getArrayOfCuisine().get(o.userKey  - 1 ).getNameDessert());
        System.out.println("Price:" + o.getArrayOfCuisine().get(o.userKey - 1).getPrice());
        System.out.println();
        System.out.println("5.Order");

        CommonPurposeView.backToTop();
        Engine.makeOrder_View();
    }


}// End of LunchView

