package com.xf.ordersys.view;

import com.xf.ordersys.core.Order;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric values responsible to
 * specific action assigned to this value (e.g 0. Cancel action)
 *
 * This class responds to sout common purpose view (e.g SystemInfo)
 *
 * @author Dawid Janik
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
//      Clear the console
//      TODO Maybe in future : )
//     */
//    public static void clearConsole(){


//    }

}
