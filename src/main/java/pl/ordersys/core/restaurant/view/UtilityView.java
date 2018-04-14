package pl.ordersys.core.restaurant.view;

import lombok.experimental.UtilityClass;
import pl.ordersys.core.restaurant.Order;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric values responsible to
 * specific action assigned to this value (e.g 0. Cancel action)
 * <p>
 * This class responds to sout common purpose view (e.g SystemInfo)
 *
 * @author Dawid Janik
 */
@UtilityClass
public class UtilityView {

    private static Order order = Order.getInstance();

    public static void viewSystemInfo() {
        System.out.println(" ============================== ");
        System.out.println(" = Food Ordering System v 0.8 = ");
        System.out.println(" ============================== ");
    }

    public static void totalAmount() {
        System.out.println("    Total Amount: " + getTotalAmount() + "$");
    }


    public static void backToTop() {
        System.out.println();
        System.out.println("0. Back to Top");
    }

    private static Double getTotalAmount() {
        return order.getTotalAmount();
    }

}
