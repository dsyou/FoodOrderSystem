package com.xf.ordersys.view;

/**
 * Created by Dawid Janik on 2016-06-29.
 * @author Dawid Janik
 *
 *
 *
 */
public class GeneralView {



    public static void view(){

        CommonPurposeView.view_SystemInfo();

        System.out.println(" 1. Make Order" );
        System.out.println(" 2. Payment");
        System.out.println();
        System.out.println(" 3. Exit");

    }

}
