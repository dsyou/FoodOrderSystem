package pl.ordersys.view;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.ordersys.core.Engine;
import pl.ordersys.core.Order;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric values responsible to
 * specific action assigned to this value (e.g 0. Back)
 * <p>
 * This class responds to sout payment content.
 *
 * @author Dawid Janik
 */
@Component
@NoArgsConstructor
public class PaymentView extends CliView {

    private static Order order = Order.getInstance();

    public void view() {
        if (order.getTotalAmount() == 0.d) {
            generateView("No purchase order found");
            getEngine().makeActionShowTransactionStatusError();
//            getEngine().makeActionShowTransactionStatusError();
        } else {
            generateView("Transaction completed successfully");
            getEngine().makeActionShowTransactionStatusSuccess();
        }
    }

    private static void generateView(String message) {
        System.out.println(message);
        System.out.println();
        System.out.println(" 0.Back ");
    }

}
