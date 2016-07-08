package com.xf.ordersys.view;

import com.xf.ordersys.core.Engine;
import com.xf.ordersys.core.Order;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric value responsible to
 * specific action assigned to this value (e.g 0. Cancel action)
 *
 * This class responds to sout Manage order content:
 *
 * @author Dawid Janik
 */
public class ManageOrderView {

    private static Order order = Order.getInstace();

//=================================================================================================================
// Methods

    public ManageOrderView() {
    }

    public static void view() {

        CommonPurposeView.view_SystemInfo();
        System.out.println(" 1.Show Order");
        System.out.println(" 5.Forgot Order");
        System.out.println();
        System.out.println(" 0.Cancel");

        Engine.makeAction_manageView();



    }

    /**
     * Purpose of this method is to show all items ordered by current transaction.
     */
    public static void view_show() {

        CommonPurposeView.view_SystemInfo();

        //List must have the same size()
        if (order.getNamesOfOrderedItems().size() != order.getPriceOfOrderedItems().size()){
            System.err.println("Oops order List are not equal");
            System.exit(-1);
        }else{
            for (int i = 0; i < order.getNamesOfOrderedItems().size(); i++) {
               System.out.println((i+1)+ "." + "  Name: " + order.getNamesOfOrderedItems().get(i) + " Price: " + order.getPriceOfOrderedItems().get(i) + "$");
            }
        }
        CommonPurposeView.totalAmount();
        CommonPurposeView.backToTop();

        Engine.makeAction_showView();
    }

}
