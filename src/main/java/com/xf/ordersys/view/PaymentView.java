package com.xf.ordersys.view;

import com.xf.ordersys.core.Engine;
import com.xf.ordersys.core.Order;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric values responsible to
 * specific action assigned to this value (e.g 0. Back)
 * <p>
 * This class responds to sout payment content.
 *
 * @author Dawid Janik
 */
public class PaymentView {

    private static Order order = Order.getInstace();

    public static void view() {

        if (order.getTotalAmount() == 0.d) { //view_error
            System.out.println("No purchase order found");
            System.out.println();
            System.out.println(" 0.Back ");

            Engine.makeAction_showTransactionStatus_Error();
        } else { //view_Successful
            System.out.println("Transaction completed successfully");
            System.out.println();
            System.out.println(" 0.Back ");

            Engine.makeAction_showTransactionStatus_Succes();
        }

    }

}
