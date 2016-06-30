package com.xf.ordersys.view;

import com.xf.ordersys.content.Drinks;

/**
 * Created by Dawid Janik on 2016-06-28.
 *
 *
 *
 */

public class DrinkView {

    public DrinkView() {
        super();
    }

    public static Drinks[] tab;

    public static void view(){
        System.out.println(" Food Ordering System v.0.1");

        System.out.println(" 1. Mochito" + tab[0]);
        System.out.println(" 2. Margaritas");
        System.out.println(" 3. Manhattan");

    }

    public static void mexico() {

    }
}
