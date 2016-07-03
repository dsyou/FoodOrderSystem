package com.xf.ordersys.view;

import com.xf.ordersys.core.Order;

/**
 * Created by Dawid Janik on 2016-06-28.
 *
 *
 */
public class CommonPurposeView {

   private static Order order = Order.getInstace();

//=================================================================================================================
//
    public static  void view_SystemInfo(){
        System.out.println(" ============================== ");
        System.out.println(" = Food Ordering System v.0.7 = ");
        System.out.println(" ============================== ");
    }



    public static void totalAmount(){
        System.out.println("    Total Amount: " + order.getTotalAmount()  + "$");
    }

    public static void backToTop(){
        System.out.println("");
        System.out.println("0. Back to Top");
    }

//    /*
//      Clear the console TODO Maybe in future : )
//     */
//    public static void clearConsole(){


//    }

}
