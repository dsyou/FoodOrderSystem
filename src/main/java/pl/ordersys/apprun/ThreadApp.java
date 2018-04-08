package pl.ordersys.apprun;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.ordersys.core.content.OrderMenu;
import pl.ordersys.core.Order;

/**
 * Contain an implementation of Thread which is used
 * for listing to incorrect user action taken from command line interfaces.
 *
 * @author Dawid Janik
 */
@Slf4j
@NoArgsConstructor
public class ThreadApp extends Thread {

    private OrderMenu orderMenu = OrderMenu.getInstance();
    private static Order order = Order.getInstance();

    /**
     * In this method Thread is always running.
     * After taken incorrect value from user choices.
     * Specific action appears.
     */
    @Override
    public void run() {
        while (true) {
            // Best Backdoor Ever :)
            if (orderMenu.getUserNavigationKey() == 9999) {
                log.debug("Back Door Exit");
                System.exit(0);
            }
            if (orderMenu.getUserNavigationKey() < 0 || orderMenu.getUserNavigationKey() >= 1000) {
                log.debug("Invalid range expression of type");
                orderMenu.setUserNavigationKey(0);
            }
            // Allowed to take order amount form 1 to 998 items per one transaction
            if (order.getQuantity() < 0 || order.getQuantity() >= 1000) {
                log.debug("Invalid range expression of type");
                order.setQuantity(0);
            }
        }
    }

}