package pl.ordersys.view;

import org.springframework.stereotype.Component;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric values responsible to
 * specific action assigned to this value (e.g 3. Exit)
 * <p>
 * This class responds to sout general command line view.
 *
 * @author Dawid Janik
 */
@Component
public class GeneralView extends CliView {

     public void view() {
        UtilityView.viewSystemInfo();

        System.out.println(" 1. Make Order");
        System.out.println(" 2. Payment");
        System.out.println();
        System.out.println(" 3. Exit");

        getEngine().makeActionOnGlobalView();
    }

}
