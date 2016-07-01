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



    public static void view() {

        CommonPurposeView.view_SystemInfo();

        System.out.println(" 1.Quantity: ");
        System.out.println(" 2.Accept ");
        System.out.println();
        System.out.println(" 0.Cancel ");

        Engine.makeAction_Order();
    }

    public static void quantity_View(){

        CommonPurposeView.view_SystemInfo();
        System.out.print(" Quantity: "); // Tutaj pobrac
        System.out.println();
        System.out.println(" 0.Cancel ");

        Engine.makeQuantity_Add();
    }


}
