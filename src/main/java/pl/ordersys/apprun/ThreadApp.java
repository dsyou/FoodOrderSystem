package pl.ordersys.apprun;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.ordersys.content.OrderMenu;
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

    private OrderMenu orderMenu = OrderMenu.getInstace();
    private static Order order = Order.getInstance();

    /**
     * In this method Thread is always running.
     * After taken incorrect value from user choices.
     * Specific action appears.
     *
     * @return void
     */
    @Override
    public void run() {
        while (true) {
            // Best Backdoor Ever :)
            if (orderMenu.userKey == 9999) {
                log.debug("Back Door Exit");
                System.exit(0);
            }
            if (orderMenu.userKey < 0 || orderMenu.userKey >= 1000) {
                log.debug("Invalid range expression of type");
                orderMenu.userKey = 0;
            }
            // Allowed to take order amount form 1 to 998 items per one transaction
            if (order.quantity < 0 || order.quantity >= 1000) {
                log.debug("Invalid range expression of type");
                order.quantity = 0;
            }
        }
    }

}