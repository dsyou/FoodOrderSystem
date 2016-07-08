package com.xf.ordersys.appRun;

import com.xf.ordersys.content.OrderMenu;
import com.xf.ordersys.core.Order;

/**
 * This class contain an implementation of Thread which is used
 * for listing to incorrect user action taken from command line interfaces
 *
 * @author Dawid Janik
  */
public class ThreadApp extends Thread {

    private OrderMenu o = OrderMenu.getInstace();
    private static Order order = Order.getInstace();
    boolean run;

    public ThreadApp() {
        super();
    }


//===================================================================
//run()

    /**
     * In this method Thread is always running.
     * After taken incorrect value from user choices.
     * Specific action appear.
     *
     * @return void
     */
    public void run() {
        run = true;

        while (run) {

            if (o.userKey == 999) { //Best Backdoor Ever :)
                System.err.println("Back Door Exit");
                System.exit(0);
            }
            if (o.userKey < 0 || o.userKey >= 1000) { // Allowed to take order amount form 1 to 998 items per one transaction
                System.err.println("Invalid range expression of type");
                o.userKey = 0;
                System.exit(-1);
            }
            if (order.quantity < 0 || order.quantity >= 1000) {
                order.quantity = 0;
                System.err.println("Invalid range expression of type");
                System.exit(-1);
            }

        }


    }

}// End of Thread Class