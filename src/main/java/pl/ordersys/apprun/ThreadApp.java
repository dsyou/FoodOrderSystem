package pl.ordersys.apprun;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.ordersys.content.OrderMenu;
import pl.ordersys.core.Order;

/**
 * This class contain an implementation of Thread which is used
 * for listing to incorrect user action taken from command line interfaces.
 *
 * @author Dawid Janik
 */
@NoArgsConstructor
public class ThreadApp extends Thread {

    private OrderMenu orderMenu = OrderMenu.getInstace();
    private static Order order = Order.getInstance();
    private boolean run;

    /**
     * In this method Thread is always running.
     * After taken incorrect value from user choices.
     * Specific action appears.
     *
     * @return void
     */
    public void run() {
        run = true;
        while (run) {
            if (orderMenu.userKey == 999) { //Best Backdoor Ever :)
                System.err.println("Back Door Exit");
                System.exit(0);
            }
            if (orderMenu.userKey < 0 || orderMenu.userKey >= 1000) { // Allowed to take order amount form 1 to 998 items per one transaction
                System.err.println("Invalid range expression of type");
                orderMenu.userKey = 0;
                System.exit(-1);
            }
            if (order.quantity < 0 || order.quantity >= 1000) {
                order.quantity = 0;
                System.err.println("Invalid range expression of type");
                System.exit(-1);
            }
        }
    }

}