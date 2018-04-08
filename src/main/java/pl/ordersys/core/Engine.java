package pl.ordersys.core;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.ordersys.core.content.OrderMenu;
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
@Component
@NoArgsConstructor(onConstructor = @__(@Autowired))
@AllArgsConstructor
public class Engine {

//    private static Order order = Order.getInstance();
//    private static OrderMenu orderMenu = OrderMenu.getInstance();

    @Autowired
    private  MainView mainView;

    @Autowired
    private LunchView lunchView;

    @Autowired
    private OrderView orderView;

    @Autowired
    private PaymentView paymentView;

    @Autowired
    private ManageOrderView manageOrderView;


    /**
     * This kind of methods are used to get user choice from
     * command line. Choosing value is saved in proper variable
     * and available for rules method defined below in Response
     * Methods section.
     */
    private Integer getUserAction() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        System.out.println("================================");
        System.out.print("Enter value... ");
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new UserInputNotParsableException();
        }
    }

    /**
     * These kind of methods are used to launch proper
     * application console view and make action if
     * need to.
     */
    public void makeActionOnGlobalView() {
        mainView.view();
//        orderMenu.setUserNavigationKey(getUserAction());
//
//        if (orderMenu.getUserNavigationKey() == 3) {
//            // Close app with 0 exit code
//            System.exit(0);
//        } else if (orderMenu.getUserNavigationKey() == 1) {
//            mainView.view();
//        } else if (orderMenu.getUserNavigationKey() == 2) {
//            paymentView.view();
//        }
    }

    public void makeActionOnMainView() {
        getUserAction();

//        switch (orderMenu.userNavigationKey) {
//            case 1: //Lunch
//                orderMenu.setMenuCheck(true);
//                LunchView.view();
//                break;
//            case 2: //Drink's
//                orderMenu.setMenuCheck(false);
////                DrinkView.view();
//                break;
//            case 4: //Forgot Order
//                ManageOrderView.view();
//                break;
//            case 5: // Exit/Logout
//                GeneralView.view();
//                break;
//            default:
//                log.debug("Cannot open view in makeActionOnMainView");
//                GeneralView.view();
//        }
    }

    public void makeActionManageView() {
//        getUserAction(); // Wait for key
//
//        if (orderMenu.getUserNavigationKey() == 1) { //Show order option
//            manageOrderView.viewShow();
//        } else if (orderMenu.getUserNavigationKey() == 5) { // Forgot all in order
//            order.dropOrder();
//            mainView.view();
//        } else checkCancelingByUser();
    }


    public void makeActionAbstrac(CliView cliView) {
        cliView.view();
    }

    public void makeActionShowTransactionStatusError() {
//       getUserAction(); // Wait for key
//
//        if (orderMenu.userNavigationKey == 0) { // Cancel or back option
//            GeneralView.view();
//        }
    }

    public void makeActionShowView() {
        getUserAction(); // Wait for key

        checkCancelingByUser();
    }

    public void makeActionShowTransactionStatusSuccess() {
//       getUserAction();
//
//        order.dropOrder();
//        if (orderMenu.userNavigationKey == 0) { // Cancel or back option
//            GeneralView.view();
//        }
    }


    public void makeActionLaunchView() {
//        getUserAction();
//        if (orderMenu.getUserNavigationKey() == 0) {
//            mainView.view();
//        } else {
////            orderMenu.setT(); = orderMenu.getUserNavigationKey() - 1;
////            System.out.println("User key t " + (orderMenu.t));
//            lunchView.viewCuisinesContent();
//        }
    }

    public void makeActionDrinkView() {
        getUserAction(); // Wait for key

//        if (orderMenu.getUserNavigationKey() == 0) {
//            mainView.view();
//        } else {
////            orderMenu.t = orderMenu.getUserNavigationKey() - 1;
////            System.out.println("User key t- Drink  " + (orderMenu.t));
////            lunchView.viewDrinksContent();
//        }
    }

    public void makeOrderView() {
        getUserAction();

//        checkCancelingByUser();
//        if (orderMenu.isMenuCheck()) { // True Launch bool flags
//            orderView.orderLaunchView();
//        } else { // False Drink
//            orderView.orderDrinkView();
//        }
    }

    private void checkCancelingByUser() {
//        if (orderMenu.getUserNavigationKey() == 0) { //Cancel
//            mainView.view();
//        }
    }

    public void makeActionLaunchOrder() {
//       getUserAction(); // Wait for key
//
//        if (orderMenu.getUserNavigationKey() == 0) { //Cancel
//            MainView.view();
//        } else if (orderMenu.getUserNavigationKey() == 1) { //Quantity + add this item into order list
//            OrderView.quantityView();
//        }
    }

    public void makeActionDrinkOrder() {
//       getUserAction(); // Wait for key
//        switch (orderMenu.getUserNavigationKey()) {
//            case 0:
//                MainView.view();
//                break;
//            case 1:
//                order.setIce(false);
//                order.setLemon(false);
//                OrderView.quantityView();
//                break;
//            case 2:
//                // Change Order name + Lemon
//                order.setIce(false);
//                order.setLemon(true);
//                OrderView.quantityView();
//                break;
//            case 3:
//                // Change Order name + Ice
//                order.setIce(true);
//                order.setLemon(false);
//                OrderView.quantityView();
//                break;
//            case 4:
//                // Change Order name Lemon + Ice
//                order.setIce(true);
//                order.setLemon(true);
//                OrderView.quantityView();
//                break;
//            default:
//                log.debug("Not proper action in drink order view");
//                GeneralView.view();
//                break;
//        }
    }

    public void makeQuantityAdd() {
//        Engine.getQuantity(); // Wait for quantity
//
//        if (order.getQuantity() == 0 || order.getQuantity() >= 100) {
//            order.setQuantity(-1); //back...
//            GeneralView.view();
//        } else {
//            for (int i = 0; i < order.getQuantity(); i++) {
//                if (orderMenu.isMenuCheck()) {
//                    order.getPriceOfOrderedItems().add(getPrice());
//                    order.getTmpPrice().add(getPrice());
//                    order.getNamesOfOrderedItems()
//                            .add(
//                                    orderMenu.getCuisines()
//                                            .get(orderMenu.t)
//                                            .getCourse() + " " + getNameDessert()
//                            );
//                } else {
//                    order.getPriceOfOrderedItems().add(getDrinkPrice());
//                    order.getTmpPrice().add(getDrinkPrice());
//                    if (!order.getLemon() && !order.getIce()) {
//                        // without lemon and ice
//                        order.getNamesOfOrderedItems().add(getDrinkName());
//                    } else if (!order.getLemon() && order.getIce()) {
//                        // with lemon, but without ice
//                        order.getNamesOfOrderedItems().add(getDrinkName() + " Ice");
//                    } else if (order.getLemon() && !order.getIce()) {
//                        // with ice, without lemon
//                        order.getNamesOfOrderedItems().add(getDrinkName() + " Lemon");
//                    } else if (order.getLemon() && order.getIce()) {
//                        // with lemon and ice
//                        order.getNamesOfOrderedItems().add(getDrinkName() + " Lemon + Ice");
//                    }
//                }
//            }
//            order.totalAmount();
//            System.out.println(order.toString());
//            GeneralView.view();
//        }
    }

    private String getNameDessert() {
//        return orderMenu.getCuisines().get(orderMenu.getT()).getDessert().getName();
        return null;
    }

    private String getDrinkName() {
//        return orderMenu.getDrinks().get(orderMenu.getT()).getName();
        return null;
    }

    private double getDrinkPrice() {
//        return orderMenu.getDrinks().get(orderMenu.getT()).getPrice();
        return 0;
    }

    private Double getPrice() {
//        return orderMenu.getCuisines().get(orderMenu.getT()).getDessert().getPrice();
        return null;
    }

}
