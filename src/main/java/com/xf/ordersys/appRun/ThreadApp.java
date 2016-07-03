package com.xf.ordersys.appRun;

import com.xf.ordersys.content.OrderMenu;
import com.xf.ordersys.core.Order;

/**
 * Created by Dawid Janik on 2016-06-28.
 *
 *
 *
 */
public class ThreadApp extends Thread {

    private OrderMenu o = OrderMenu.getInstace();
    private static Order order = Order.getInstace();
    boolean run;

    public ThreadApp() {
        super();
    }

    //TODO Exception -> General View

//===================================================================
//run()
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
                run = false;
                System.exit(-1);
            }
            if (order.quantity < 0 || order.quantity >= 1000) {
                order.quantity = 0;
                run = false;
                System.err.println("Invalid range expression of type");
                System.exit(-1);
            }

        }


    }

}// End of Thread Class