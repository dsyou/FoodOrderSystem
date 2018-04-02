package pl.ordersys.view;

import lombok.experimental.UtilityClass;
import pl.ordersys.core.Engine;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric values responsible to
 * specific action assigned to this value (e.g 3. Exit)
 *
 * This class responds to sout general command line view.
 *
 * @author Dawid Janik
 */
@UtilityClass
public class GeneralView {

    public static void view(){
        CommonPurposeView.viewSystemInfo();

        System.out.println(" 1. Make Order" );
        System.out.println(" 2. Payment");
        System.out.println();
        System.out.println(" 3. Exit");

        Engine.makeActionGlobalView();
    }

}
