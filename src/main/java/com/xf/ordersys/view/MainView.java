package com.xf.ordersys.view;

import com.xf.ordersys.core.Engine;

/**
 * Created by Dawid Janik  on 2016-06-28.
 */
public class MainView {

    public MainView(){
        super();
    }

    //
    public static void view(){

        CommonPurposeView.view_SystemInfo();

        System.out.println(" 1.Lunch");
        System.out.println(" 2.Drink's");
        CommonPurposeView.totalAmount();     //System.out.println("    Total Amount: ");

        System.out.println(" 4.Show/Forgot Order"); // To jest stale
        System.out.println(" 5.Back");  // ?? numery sie zmieniaja

        Engine.makeAction_mainView();
    }




}
