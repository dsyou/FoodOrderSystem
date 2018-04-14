package pl.ordersys.core.restaurant.view;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.ordersys.core.restaurant.Order;

import static pl.ordersys.core.restaurant.Order.getOrderedItems;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric values responsible to
 * specific action assigned to this value (e.g 0. Cancel action)
 * <p>
 * This class responds to sout Manage order content:
 *
 * @author Dawid Janik
 */
@Component
@NoArgsConstructor
public class ManageOrderView extends CliView {

    private static Order order = Order.getInstance();

    public void view() {
        UtilityView.viewSystemInfo();
        System.out.println(" 1.Show Order");
        System.out.println(" 5.Forgot Order");
        System.out.println();
        System.out.println(" 0.Cancel");

        getEngine().makeActionManageView();
//        getEngine().makeActionManageView();
    }

    /**
     * Purpose of this method is to show all items ordered by current transaction.
     */
    public void viewShow() {
        UtilityView.viewSystemInfo();

        //List must have the same size()
        if (order.getNamesOfOrderedItems().size() != order.getPriceOfOrderedItems().size()) {
            System.err.println("Oops order List are not equal");
            //todo write exception here
            System.exit(-1);
        } else {
            getOrderedItems();
        }
        UtilityView.totalAmount();
        UtilityView.backToTop();

        getEngine().makeActionShowView();
    }


}
