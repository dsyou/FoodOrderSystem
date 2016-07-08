package com.xf.ordersys.view;

import com.xf.ordersys.content.OrderMenu;
import com.xf.ordersys.core.Engine;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric value responsible to
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

    private static OrderMenu o = OrderMenu.getInstace();

//=================================================================================================================
// Methods



    public static void view(){

        CommonPurposeView.view_SystemInfo();

        for (int i = 0; i < o.getArrayOfDrinks().size(); i++) {
            System.out.println("" + (i + 1) + "." + o.getArrayOfDrinks().get(i).getName() ); //+ " $" + o.getArrayOfDrinks().get(i).getPrice()
        }

        CommonPurposeView.totalAmount();
        CommonPurposeView.backToTop();

        Engine.makeAction_drinkView();
    }



    //ice cubes or/and lemon
    public static void view_DrinksContent() {

        CommonPurposeView.view_SystemInfo();

        System.out.println("Drink name: " + o.getArrayOfDrinks().get(o.userKey - 1 ).getName());

        System.out.println("Price:" + o.getArrayOfDrinks().get(o.userKey - 1).getPrice() + "$");
        System.out.println();
        System.out.println("5.Order");

        CommonPurposeView.backToTop();
        Engine.makeOrder_View();
    }




} // End of DrinkView
