package pl.ordersys.core;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import pl.ordersys.content.OrderMenu;
import pl.ordersys.core.exception.UserInputNotParsableException;
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
@Slf4j
@UtilityClass
public class Engine {

    private static Order order = Order.getInstance();
    private static OrderMenu orderMenu = OrderMenu.getInstance();

    /**
     * This kind of methods are used to get user choice from
     * command line. Choosing value is saved in proper variable
     * and available for rules method defined below in Response
     * Methods section.
     */
    private static void getUserAction() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        System.out.print("Your Choice...");
        try {
            orderMenu.userKey = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            throw new UserInputNotParsableException();
        }
        System.out.println("********************************");
    }

    private static void getQuantity() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        System.out.print("Enter amount...");
        try {
            order.quantity = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            throw new UserInputNotParsableException();
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
        // Wait for key from user
        Engine.getUserAction();

        if (orderMenu.userKey == 999) {
            System.exit(0);
        } else {
            switch (orderMenu.userKey) {
                case 1: //Lunch
                    orderMenu.setMenuCheck(true);
                    LunchView.view();
                    break;
                case 2: //Drink's
                    orderMenu.setMenuCheck(false);
                    DrinkView.view();
                    break;
                case 4: //Forgot Order
                    ManageOrderView.view();
                    break;
                case 5: // Exit/Logout
                    GeneralView.view();
                    break;
                default:
                    log.debug("Cannot open view in makeActionMainView");
                    GeneralView.view();
            }
        }
    }

    public static void makeActionManageView() {
        Engine.getUserAction(); // Wait for key

        if (orderMenu.userKey == 1) { //Show order option
            ManageOrderView.viewShow();
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
            orderMenu.t = orderMenu.userKey - 1;
            System.out.println("User key t " + (orderMenu.t));
            LunchView.viewCuisinesContent();
        }
    }

    public static void makeActionDrinkView() {
        Engine.getUserAction(); // Wait for key

        if (orderMenu.userKey == 0) { //999
            MainView.view();
        } else {
            orderMenu.t = orderMenu.userKey - 1;
            System.out.println("User key t- Drinks  " + (orderMenu.t));
            DrinkView.viewDrinksContent();
        }
    }

    public static void makeOrderView() {
        Engine.getUserAction();

        if (orderMenu.userKey == 0) { //Cancel
            MainView.view();
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
            MainView.view();
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
                log.debug("Not proper action in drink order view");
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
            for (int i = 0; i < order.quantity; i++) {
                if (orderMenu.isMenuCheck()) {
                    order.getPriceOfOrderedItems().add(getPrice());
                    order.getTmpPrice().add(getPrice());
                    order.getNamesOfOrderedItems().add(
                            orderMenu.getArrayOfCuisine()
                                    .get(orderMenu.t)
                                    .getNameMainCourse() + " " + getNameDessert());
                } else {
                    if (!order.getLemon() && !order.getIce()) {
                        // without lemon and ice
                        order.getPriceOfOrderedItems().add(getDrinkPrice());
                        order.getTmpPrice().add(getDrinkPrice());
                        order.getNamesOfOrderedItems().add(getDrinkName());
                    } else if (!order.getLemon() && order.getIce()) {
                        // with lemon, but without ice
                        order.getPriceOfOrderedItems().add(getDrinkPrice());
                        order.getTmpPrice().add(getDrinkPrice());
                        order.getNamesOfOrderedItems().add(getDrinkName() + " Ice");
                    } else if (order.getLemon() && !order.getIce()) {
                        // with ice, without lemon
                        order.getPriceOfOrderedItems().add(getDrinkPrice());
                        order.getTmpPrice().add(getDrinkPrice());
                        order.getNamesOfOrderedItems().add(getDrinkName() + " Lemon");
                    } else if (order.getLemon() && order.getIce()) {
                        // with lemon and ice
                        order.getPriceOfOrderedItems().add(getDrinkPrice());
                        order.getTmpPrice().add(getDrinkPrice());
                        order.getNamesOfOrderedItems().add(getDrinkName() + " Lemon + Ice");
                    }
                }
            }
            order.totalAmount();
            System.out.println(order.toString());
            GeneralView.view();
        }
    }

    private static String getNameDessert() {
        return orderMenu.getArrayOfCuisine().get(orderMenu.t).getNameDessert();
    }

    private static String getDrinkName() {
        return orderMenu.getArrayOfDrinks().get(orderMenu.t).getName();
    }

    private static double getDrinkPrice() {
        return orderMenu.getArrayOfDrinks().get(orderMenu.t).getPrice();
    }

    private static Double getPrice() {
        return orderMenu.getArrayOfCuisine().get(orderMenu.t).getPrice();
    }

}
