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
    private static Order order = Order.getInstace();


    public Engine(){
        super();
    }
//===================================================================
//
    public static void getUserAction()  {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);

        System.out.print("Your Choice...");

        try {
            o.userKey  = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("********************************");

    }
    public static void getUserAction_Quantity()  {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);

        System.out.print("Enter amount...");

        try {
            order.quantity = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("********************************");

    }
//===================================================================
//Response Methods

//public static void makeAction_globalView(){
//
//    Engine.getUserAction(); // Wait for key
//
//    if (o.userKey == 999) { //999
//        MainView.view();
//    }else{
//        LunchView.view_CuisinesContent();
//    }
//}

    public static void makeAction_globalView(){

        Engine.getUserAction(); // Wait for key

        if (o.userKey == 999 || o.userKey == 3) { //999
            System.exit(0); // Close app with 0 exit code
        }else if (o.userKey == 1){
            MainView.view();
        }else if (o.userKey == 2){
            PaymentView.view();
        }
    }

    public static void makeAction_mainView(){

        Engine.getUserAction(); // Wait for key

        if (o.userKey == 999 ) { //999
           System.exit(0);
        }else {
            switch (o.userKey) {

                case 1: //Lunch
                    LunchView.view();
                    // Engine.actionLunch(Engine.getUserAction());
                    break;
                case 2: //Drink's
                    DrinkView.view();
                    //   Engine.actionDrinks(Engine.getUserAction());
                    break;
                case 4: //Forgot Order
                    MangeOrderVIew.view();
                    //  Engine.actionLunch(Engine.getUserAction());
                    break;
                case 5: // Exit/Logout
                     GeneralView.view();
                      //   Engine.actionLunch(Engine.getUserAction());
                     break;

                default:
                    System.err.println("Something very bad here...LunchView");
            }
        }
    }
//===================================================================
// Manage
    public static void makeAction_manageView() {
        Engine.getUserAction(); // Wait for key

        if (o.userKey == 1) { //Show order option

        } else if (o.userKey == 5) { // Forgot all in order
            order.dropOrder();
            MainView.view();
        } else if (o.userKey == 0) { // Cancel back option
            MainView.view();
        }
    }
//===================================================================
// Launch

    public static void makeAction_launchView(){

        Engine.getUserAction(); // Wait for key

        if ( o.userKey == 0) { //999
            MainView.view();
        }else{
           //o.getArrayOfCuisine().get(o.userKey -1);//
            LunchView.view_CuisinesContent();
        }
    }


//===================================================================
//Drinks

    public static void makeAction_drinkView(){

        Engine.getUserAction(); // Wait for key

        if (o.userKey == 999) { //999
            System.exit(0);
        }else{
          //  action();
        }
    }

//===================================================================
//Make Order

    public static void makeOrder_View(){
            Engine.getUserAction();
            if (o.userKey == 0) { //Cancel
                MainView.view(); //Or maybe LunchView.view();
            }
            OrderView.view();
    }

    public static void makeAction_Order() {

        Engine.getUserAction(); // Wait for key

        if (o.userKey == 0) { //Cancel
            MainView.view(); //Or maybe LunchView.view();
        }else if (o.userKey == 1){ //Quantity + add this item into order list
            OrderView.quantity_View();

        }else if (o.userKey == 2) { // Accept, and back into  LunchView
            LunchView.view();
        }

    }

    public static void makeQuantity_Add(){

        Engine.getUserAction_Quantity(); // Wait for quantity
        // for ilosc tyle dodaj
        if (order.quantity == 0){
            //back...
        }else{
            for (int i=0 ; i <order.quantity; i++){
                order.getPriceOfOrderedItems().add( o.getArrayOfCuisine().get(o.userKey - 1).getPrice() );    //ilosc
                order.getNamesOfOrderedItems().add( o.getArrayOfCuisine().get(o.userKey - 1).getNameMainCourse() + " " + o.getArrayOfCuisine().get(o.userKey - 1).getNameDessert() );  //zamowienie
            }
            order.totalAmount();
            System.out.println(order.toString());
            LunchView.view();
        }


    }



} // End of Engine
