package com.xf.ordersys.view;

import com.xf.ordersys.core.Engine;

/**
 * Created by XCVB on 2016-06-28.
 * @author  Dawid Janik
 *
 *
 *
 */
public class OrderView {


//=================================================================================================================
//

    public static void orderLaunch_View() {

        CommonPurposeView.view_SystemInfo();

        System.out.println(" 1.Quantity ");
        //System.out.println(" 2.Accept ");
        System.out.println();
        System.out.println(" 0.Cancel ");

        Engine.makeActionLaunch_Order();
    }

    public static void orderDrink_View() {

        CommonPurposeView.view_SystemInfo();

        System.out.println(" 1.Quantity ");
        System.out.println(" 2. Extra Lemon ");
        System.out.println(" 3. Extra Ice cubes ");
        System.out.println(" 5.Accept ");
        System.out.println();
        System.out.println(" 0.Cancel ");

        Engine.makeActionDrink_Order();
    }

    public static void quantity_View(){

        CommonPurposeView.view_SystemInfo();
        System.out.print(" Quantity: "); // Here take quantity
        System.out.println();
        System.out.println(" 0.Cancel ");

        Engine.makeQuantity_Add();
    }


}
