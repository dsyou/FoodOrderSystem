package com.xf.ordersys.view;

import com.xf.ordersys.content.OrderMenu;
import com.xf.ordersys.core.Engine;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Dawid Janik on 2016-06-28.
 *
 *
 */
public class LunchView {


    public LunchView() {
        super();
    } //

    private static OrderMenu o = OrderMenu.getInstace();


//=================================================================================================================
//Another Methods

    public static void view() {

        CommonPurposeView.view_SystemInfo();

        for (int i = 0; i < o.getArrayOfCuisine().size(); i++) {
            System.out.println("" + (i + 1) + "." + o.getArrayOfCuisine().get(i).getName());
        }

        CommonPurposeView.totalAmount();
        CommonPurposeView.backToTop();

        Engine.makeAction();

//        Engine.getUserAction();
//        view_CuisinesContent();
    }
        /*
            999 - Back To Top

        */
        public static void makeAction(){

            Engine.getUserAction(); // Wait for key

           if (o.userKey == 999) { //999
                MainView.view();
           }else{
                view_CuisinesContent();
           }
        }


    public void getActionFromUser() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.print(" Your choice: ");
        //        String s=br.readLine(); // Jest Stringem
        // int x= Integer.parseInt(br.readLine());
        //Engine.action(x);
    }

    public static void view_CuisinesContent() {


        System.out.println("Main course: " + o.getArrayOfCuisine().get(o.userKey + 1).getNameMainCourse());
        System.out.println("Dessert: " + o.getArrayOfCuisine().get(o.userKey + 1).getNameDessert());
        System.out.println("Price:" + o.getArrayOfCuisine().get(o.userKey + 1).getPrice());
        System.out.println("5.Order");

    }


    //view Ilosc i wziasc (Acept)




}// End of LunchView

