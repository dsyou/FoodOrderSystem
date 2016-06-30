package com.xf.ordersys.core;

import com.xf.ordersys.content.OrderMenu;
import com.xf.ordersys.view.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dawid Janik on 2016-06-27.
 *
 *
 *
 */
public class Engine {


    private static OrderMenu o = OrderMenu.getInstace();

        public static void test(){

        }


    public static void makeAction(){

        Engine.getUserAction(); // Wait for key

        if (o.userKey == 999) { //999
            MainView.view();
        }else{
            LunchView.view_CuisinesContent();
        }
    }

    public static void makeAction_mainView(){

        Engine.getUserAction(); // Wait for key

        if (o.userKey == 999) { //999
           System.exit(0);
        }else{
            action();
        }
    }


    public static void makeAction_launchView(){

        Engine.getUserAction(); // Wait for key

        if (o.userKey == 999) { //999
            System.exit(0);
        }else{
            action();
        }
    }

    public static void makeAction_drinkView(){

        Engine.getUserAction(); // Wait for key

        if (o.userKey == 999) { //999
            System.exit(0);
        }else{
            action();
        }
    }


/*
    Take action from user response
 */
    public static void action(){

        switch (o.userKey){

            case 1: //Lunch
                LunchView.view();
               // Engine.actionLunch(Engine.getUserAction());
                break;
            case 2: //Drink's
                DrinkView.view();
             //   Engine.actionDrinks(Engine.getUserAction());
                break;
            case 4: //Forgot Order
                ForgotOrder.view();
              //  Engine.actionLunch(Engine.getUserAction());
                break;
            case 5: // Exit/Logout
                SystemView.view();
             //   Engine.actionLunch(Engine.getUserAction());
                break;

            default:
                System.err.println("Something very bad here...");
        }
      //  Engine.action(Engine.getUserAction());
    }


    /*
        Take action from user response
     */
    public static void actionLunch(int i){

        switch (i){

//            case 1: //Lunch Polish
//                LunchView.polish();
//
//                break;
//
//            case 2: //Lunch Mexican
//                LunchView.mexico();
//
//                break;
//            case 3: //Lunch Italian
//                LunchView.italian();

             //   break;
            case 9: // Exit/Logout
                SystemView.view();

                break;

            default:
                System.err.println("Something very bad in actionLunch...");
        }
        Engine.getUserAction();
    }


    /*
    Take action from user response
 */
    public static void actionDrinks(int i){

        switch (i){

//            case 1: // drink_1
//                LunchView.polish();
//                Engine.getUserAction();
//                break;
//
//            case 2: //drink_2
//                LunchView.mexico();
//
//                break;
//            case 3: //drink_2
//                LunchView.italian();

              //  break;
            case 9: // Exit/Logout
                SystemView.view();

                break;

            default:
                System.err.println("Something very bad in actionDrink...");
        }

    }


    private static void forgotOrder_View() {
    }

    private static void exitLogoutView() {

    }

    private static void forgotOrder() {
    }

    private static void drinkView() {
    }

    private static void lunchView() {

        System.out.println("Food System Order v. 0.1");
        System.out.println("");
        System.out.println("1. Polish");
        System.out.println("2. Mexican");
        System.out.println("2. Italian");
    }


    public String totalAmount(){

    return "";
}

    public static void getUserAction()  {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);

        System.out.print("Your Choice...");

        try {
              o.userKey  = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("======================================");

    }


}
