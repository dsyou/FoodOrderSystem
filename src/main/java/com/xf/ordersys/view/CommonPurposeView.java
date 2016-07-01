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
        System.out.println(" = Food Ordering System v.0.4 = ");
        System.out.println(" ============================== ");
    }

    //ilosc towaru
    public static void quantity(){
            // ile bieremy sztuk
    }

    public static void totalAmount(){
        System.out.println("    Total Amount: " + order.getTotalAmount()  + "$");
    }

    public static void backToTop(){
        System.out.println("");
        System.out.println("0. Back to Top"); //TODO powrot zawsze do Glownego View !!! Or Exit
    }

    /*
      Clear the console
     */
    public static void clearConsole(){
        // Ten Skok to zly pomysl
//        char c = '\n';
//        int length = 25;
//        char[] chars = new char[length];
//
//        Arrays.fill(chars, c);
//        System.out.print(String.valueOf(chars));
    }

}
