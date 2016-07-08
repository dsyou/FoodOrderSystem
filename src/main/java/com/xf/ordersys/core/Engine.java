package com.xf.ordersys.core;

import com.xf.ordersys.content.OrderMenu;
import com.xf.ordersys.view.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Dawid Janik
 */
public class Engine {


    private static OrderMenu o = OrderMenu.getInstace();
    private static Order order = Order.getInstace();


    public Engine(){
        super();
    }

//===================================================================
// Get Response to User Action

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
                    o.setMenu_check(true);
                   // System.out.println("o.menu_check " + o.menu_check);
                    LunchView.view();
                    // Engine.actionLunch(Engine.getUserAction());
                    break;
                case 2: //Drink's
                    o.setMenu_check(false);
                   // System.out.println("o.menu_check " + o.menu_check);
                    DrinkView.view();
                    //   Engine.actionDrinks(Engine.getUserAction());
                    break;
                case 4: //Forgot Order
                    ManageOrderView.view();
                    //  Engine.actionLunch(Engine.getUserAction());
                    break;
                case 5: // Exit/Logout
                     GeneralView.view();
                      //   Engine.actionLunch(Engine.getUserAction());
                     break;

                default:
                    System.err.println("Something very bad here...makeAction_mainView");
                    GeneralView.view();
            }
        }
    }
//===================================================================
// Manage --- show/drop order
    public static void makeAction_manageView() {
        Engine.getUserAction(); // Wait for key

        if (o.userKey == 1) { //Show order option
            ManageOrderView.view_show();
        } else if (o.userKey == 5) { // Forgot all in order
            order.dropOrder();
            MainView.view();
        } else if (o.userKey == 0) { // Cancel back option
            MainView.view();
        }
    }
    public static void makeAction_showView() {
        Engine.getUserAction(); // Wait for key

         if (o.userKey == 0) { // Cancel or back option
            MainView.view();
        }
    }

    public static void makeAction_showTransactionStatus_Succes() {
        Engine.getUserAction(); // Wait for key

        order.dropOrder();
        if (o.userKey == 0) { // Cancel or back option
            GeneralView.view();
        }
    }

    public static void makeAction_showTransactionStatus_Error() {
        Engine.getUserAction(); // Wait for key

        if (o.userKey == 0) { // Cancel or back option
            GeneralView.view();
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
            o.t = o.userKey - 1;
            System.out.println("User key t " + (o.t));
            LunchView.view_CuisinesContent();

        }
    }


//===================================================================
//Drinks

    public static void makeAction_drinkView(){

        Engine.getUserAction(); // Wait for key

        if (o.userKey == 0) { //999
            MainView.view();
        }else{
            o.t = o.userKey - 1;
            System.out.println("User key t- Drinks  " + (o.t));
            DrinkView.view_DrinksContent();
        }
    }

//===================================================================
//Make Order

    public static void makeOrder_View(){
            Engine.getUserAction();

            if (o.userKey == 0) { //Cancel
                MainView.view(); //Or maybe LunchView.orderLaunch_View();
            }
            if (o.isMenu_check()){ // True Launch bool flags
                OrderView.orderLaunch_View();
            }else{ // False Drinks
                OrderView.orderDrink_View();
            }
    }

    public static void makeActionLaunch_Order() {

        Engine.getUserAction(); // Wait for key

        if (o.userKey == 0) { //Cancel
            MainView.view(); //Or maybe LunchView.orderLaunch_View();
        }else if (o.userKey == 1){ //Quantity + add this item into order list
            OrderView.quantity_View();
        }

    }

    public static void makeActionDrink_Order() {

        Engine.getUserAction(); // Wait for key

        switch (o.userKey){

            case 0:
                MainView.view();
                break;
            case 1:
                order.setIce(false); order.setLemon(false);
                OrderView.quantity_View();
                break;
            case 2:
                // Change Order name + Lemon
                order.setIce(false); order.setLemon(true);
                OrderView.quantity_View();
                break;
            case 3:
                // Change Order name + Ice
                order.setIce(true); order.setLemon(false);
                OrderView.quantity_View();
                break;
            case 4:
                // Change Order name Lemon + Ice
                order.setIce(true); order.setLemon(true);
                OrderView.quantity_View();
                break;

            default:
                System.err.println("");
                GeneralView.view();
                break;
        }

    }

    public static void makeQuantity_Add(){

        Engine.getUserAction_Quantity(); // Wait for quantity

        if (order.quantity == 0 || (order.quantity >= 100)){
            order.quantity = -1; //back...
            GeneralView.view();
        }else{
            //System.out.println("User key t " + (o.t));
            for (int i=0 ; i <order.quantity; i++){

                if(o.isMenu_check()){
                    order.getPriceOfOrderedItems().add( o.getArrayOfCuisine().get(o.t).getPrice() );
                    order.getTmp().add( o.getArrayOfCuisine().get(o.t).getPrice() );
                    order.getNamesOfOrderedItems().add( o.getArrayOfCuisine().get(o.t).getNameMainCourse() + " " + o.getArrayOfCuisine().get(o.t).getNameDessert() );  //zamowienie
                }else{
                    if (!order.getLemon() && !order.getIce()){
                        // without Limom and ice
                        order.getPriceOfOrderedItems().add( o.getArrayOfDrinks().get(o.t).getPrice() );
                        order.getTmp().add( o.getArrayOfDrinks().get(o.t).getPrice() );
                        order.getNamesOfOrderedItems().add( o.getArrayOfDrinks().get(o.t).getName() );
                    }else if (!order.getLemon() && order.getIce()){
                        // with limon, but without ice
                        order.getPriceOfOrderedItems().add( o.getArrayOfDrinks().get(o.t).getPrice() );
                        order.getTmp().add( o.getArrayOfDrinks().get(o.t).getPrice() );
                        order.getNamesOfOrderedItems().add( o.getArrayOfDrinks().get(o.t).getName() + " Ice" );
                    }else if (order.getLemon() && !order.getIce()){
                        // with ice, without limon
                        order.getPriceOfOrderedItems().add( o.getArrayOfDrinks().get(o.t).getPrice() );
                        order.getTmp().add( o.getArrayOfDrinks().get(o.t).getPrice() );
                        order.getNamesOfOrderedItems().add( o.getArrayOfDrinks().get(o.t).getName() + " Lemon" );
                    }else if (order.getLemon() && order.getIce()){
                        // with limon and ice
                        order.getPriceOfOrderedItems().add( o.getArrayOfDrinks().get(o.t).getPrice() );
                        order.getTmp().add( o.getArrayOfDrinks().get(o.t).getPrice() );
                        order.getNamesOfOrderedItems().add( o.getArrayOfDrinks().get(o.t).getName() + " Lemon + Ice");
                    }
//
//                    order.getPriceOfOrderedItems().add( o.getArrayOfDrinks().get(o.t).getPrice() );
//                    order.getTmp().add( o.getArrayOfDrinks().get(o.t).getPrice() );
//                    order.getNamesOfOrderedItems().add( o.getArrayOfDrinks().get(o.t).getName() );
                }

            }
            order.totalAmount();
            System.out.println(order.toString());
            GeneralView.view();
        }

    }


} // End of Engine
