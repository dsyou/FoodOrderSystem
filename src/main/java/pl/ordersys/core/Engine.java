package pl.ordersys.core;

import lombok.NoArgsConstructor;
import pl.ordersys.content.OrderMenu;
import pl.ordersys.view.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class consists methods that perform proper action
 * depends on user choice. In another way these Methods are
 * to navigate among each specific command - line view
 * interface.
 *
 * @author Dawid Janik
 */
@NoArgsConstructor
public class Engine {

    private static Order order = Order.getInstance();
    private static OrderMenu orderMenu = OrderMenu.getInstace();

    /**
     * This kind of methods are used to get user choice from
     * command line. Choosing value is saved in proper variable
     * and available for rules method defined below in Response
     * Methods section.
     */
    public static void getUserAction() {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        System.out.print("Your Choice...");

        try {
            orderMenu.userKey = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("********************************");
    }

    public static void getQuantity() {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        System.out.print("Enter amount...");

        try {
            order.quantity = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("********************************");
    }

    /**
     * These kind of methods are used to launch proper
     * application console view and make action if
     * need to.
     */
    public static void makeActionGlobalView() {

        Engine.getUserAction(); // Wait for key

        if (orderMenu.userKey == 999 || orderMenu.userKey == 3) { //999
            System.exit(0); // Close app with 0 exit code
        } else if (orderMenu.userKey == 1) {
            MainView.view();
        } else if (orderMenu.userKey == 2) {
            PaymentView.view();
        }
    }

    public static void makeActionMainView() {

        Engine.getUserAction(); // Wait for key

        if (orderMenu.userKey == 999) { //999
            System.exit(0);
        } else {
            switch (orderMenu.userKey) {

                case 1: //Lunch
                    orderMenu.setMenuCheck(true);
                    // System.out.println("orderMenu.menu_check " + orderMenu.menu_check);
                    LunchView.view();
                    // Engine.actionLunch(Engine.getUserAction());
                    break;
                case 2: //Drink's
                    orderMenu.setMenuCheck(false);
                    // System.out.println("orderMenu.menu_check " + orderMenu.menu_check);
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
                    System.err.println("Something very bad here...makeActionMainView");
                    GeneralView.view();
            }
        }
    }
    public static void makeActionManageView() {
        Engine.getUserAction(); // Wait for key

        if (orderMenu.userKey == 1) { //Show order option
            ManageOrderView.view_show();
        } else if (orderMenu.userKey == 5) { // Forgot all in order
            order.dropOrder();
            MainView.view();
        } else if (orderMenu.userKey == 0) { // Cancel back option
            MainView.view();
        }
    }

    public static void makeActionShowView() {
        Engine.getUserAction(); // Wait for key

        if (orderMenu.userKey == 0) { // Cancel or back option
            MainView.view();
        }
    }

    public static void makeActionShowTransactionStatusSuccess() {
        Engine.getUserAction(); // Wait for key

        order.dropOrder();
        if (orderMenu.userKey == 0) { // Cancel or back option
            GeneralView.view();
        }
    }

    public static void makeActionShowTransactionStatusError() {
        Engine.getUserAction(); // Wait for key

        if (orderMenu.userKey == 0) { // Cancel or back option
            GeneralView.view();
        }
    }

    public static void makeActionLaunchView() {

        Engine.getUserAction(); // Wait for key

        if (orderMenu.userKey == 0) { //999
            MainView.view();
        } else {
            //orderMenu.getArrayOfCuisine().get(orderMenu.userKey -1);//
            orderMenu.t = orderMenu.userKey - 1;
            System.out.println("User key t " + (orderMenu.t));
            LunchView.view_CuisinesContent();

        }
    }

    public static void makeActionDrinkView() {

        Engine.getUserAction(); // Wait for key

        if (orderMenu.userKey == 0) { //999
            MainView.view();
        } else {
            orderMenu.t = orderMenu.userKey - 1;
            System.out.println("User key t- Drinks  " + (orderMenu.t));
            DrinkView.view_DrinksContent();
        }
    }
    public static void makeOrderView() {
        Engine.getUserAction();

        if (orderMenu.userKey == 0) { //Cancel
            MainView.view(); //Or maybe LunchView.orderLaunchView();
        }
        if (orderMenu.isMenuCheck()) { // True Launch bool flags
            OrderView.orderLaunchView();
        } else { // False Drinks
            OrderView.orderDrinkView();
        }
    }

    public static void makeActionLaunchOrder() {

        Engine.getUserAction(); // Wait for key

        if (orderMenu.userKey == 0) { //Cancel
            MainView.view(); //Or maybe LunchView.orderLaunchView();
        } else if (orderMenu.userKey == 1) { //Quantity + add this item into order list
            OrderView.quantityView();
        }

    }

    public static void makeActionDrinkOrder() {

        Engine.getUserAction(); // Wait for key

        switch (orderMenu.userKey) {

            case 0:
                MainView.view();
                break;
            case 1:
                order.setIce(false);
                order.setLemon(false);
                OrderView.quantityView();
                break;
            case 2:
                // Change Order name + Lemon
                order.setIce(false);
                order.setLemon(true);
                OrderView.quantityView();
                break;
            case 3:
                // Change Order name + Ice
                order.setIce(true);
                order.setLemon(false);
                OrderView.quantityView();
                break;
            case 4:
                // Change Order name Lemon + Ice
                order.setIce(true);
                order.setLemon(true);
                OrderView.quantityView();
                break;
            default:
                System.err.println();
                GeneralView.view();
                break;
        }

    }

    public static void makeQuantityAdd() {

        Engine.getQuantity(); // Wait for quantity

        if (order.quantity == 0 || (order.quantity >= 100)) {
            order.quantity = -1; //back...
            GeneralView.view();
        } else {
            //System.out.println("User key t " + (orderMenu.t));
            for (int i = 0; i < order.quantity; i++) {

                if (orderMenu.isMenuCheck()) {
                    order.getPriceOfOrderedItems().add(orderMenu.getArrayOfCuisine().get(orderMenu.t).getPrice());
                    order.getTmpPrice().add(orderMenu.getArrayOfCuisine().get(orderMenu.t).getPrice());
                    order.getNamesOfOrderedItems().add(orderMenu.getArrayOfCuisine().get(orderMenu.t).getNameMainCourse() + " " + orderMenu.getArrayOfCuisine().get(orderMenu.t).getNameDessert());  //zamowienie
                } else {
                    if (!order.getLemon() && !order.getIce()) {
                        // without Limom and ice
                        order.getPriceOfOrderedItems().add(orderMenu.getArrayOfDrinks().get(orderMenu.t).getPrice());
                        order.getTmpPrice().add(orderMenu.getArrayOfDrinks().get(orderMenu.t).getPrice());
                        order.getNamesOfOrderedItems().add(orderMenu.getArrayOfDrinks().get(orderMenu.t).getName());
                    } else if (!order.getLemon() && order.getIce()) {
                        // with limon, but without ice
                        order.getPriceOfOrderedItems().add(orderMenu.getArrayOfDrinks().get(orderMenu.t).getPrice());
                        order.getTmpPrice().add(orderMenu.getArrayOfDrinks().get(orderMenu.t).getPrice());
                        order.getNamesOfOrderedItems().add(orderMenu.getArrayOfDrinks().get(orderMenu.t).getName() + " Ice");
                    } else if (order.getLemon() && !order.getIce()) {
                        // with ice, without limon
                        order.getPriceOfOrderedItems().add(orderMenu.getArrayOfDrinks().get(orderMenu.t).getPrice());
                        order.getTmpPrice().add(orderMenu.getArrayOfDrinks().get(orderMenu.t).getPrice());
                        order.getNamesOfOrderedItems().add(orderMenu.getArrayOfDrinks().get(orderMenu.t).getName() + " Lemon");
                    } else if (order.getLemon() && order.getIce()) {
                        // with limon and ice
                        order.getPriceOfOrderedItems().add(orderMenu.getArrayOfDrinks().get(orderMenu.t).getPrice());
                        order.getTmpPrice().add(orderMenu.getArrayOfDrinks().get(orderMenu.t).getPrice());
                        order.getNamesOfOrderedItems().add(orderMenu.getArrayOfDrinks().get(orderMenu.t).getName() + " Lemon + Ice");
                    }
//
//                    order.getPriceOfOrderedItems().add( orderMenu.getArrayOfDrinks().get(orderMenu.t).getPrice() );
//                    order.getTmpPrice().add( orderMenu.getArrayOfDrinks().get(orderMenu.t).getPrice() );
//                    order.getNamesOfOrderedItems().add( orderMenu.getArrayOfDrinks().get(orderMenu.t).getName() );
                }

            }
            order.totalAmount();
            System.out.println(order.toString());
            GeneralView.view();
        }

    }

}
