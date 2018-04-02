package pl.ordersys.view;

import lombok.NoArgsConstructor;
import pl.ordersys.core.Engine;
import pl.ordersys.core.Order;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric values responsible to
 * specific action assigned to this value (e.g 0. Cancel action)
 * <p>
 * This class responds to sout Manage order content:
 *
 * @author Dawid Janik
 */
@NoArgsConstructor
public class ManageOrderView {

    private static Order order = Order.getInstance();

    public static void view() {
        CommonPurposeView.viewSystemInfo();
        System.out.println(" 1.Show Order");
        System.out.println(" 5.Forgot Order");
        System.out.println();
        System.out.println(" 0.Cancel");

        Engine.makeActionManageView();
    }

    /**
     * Purpose of this method is to show all items ordered by current transaction.
     */
    public static void viewShow() {
        CommonPurposeView.viewSystemInfo();

        //List must have the same size()
        if (order.getNamesOfOrderedItems().size() != order.getPriceOfOrderedItems().size()) {
            System.err.println("Oops order List are not equal");
            System.exit(-1);
        } else {
            for (int i = 0; i < order.getNamesOfOrderedItems().size(); i++) {
                System.out.println((i + 1) + "." + "  Name: " + order.getNamesOfOrderedItems().get(i) + " Price: " + order.getPriceOfOrderedItems().get(i) + "$");
            }
        }
        CommonPurposeView.totalAmount();
        CommonPurposeView.backToTop();

        Engine.makeActionShowView();
    }

}
