package pl.ordersys.view;

import lombok.experimental.UtilityClass;
import pl.ordersys.core.Engine;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric values responsible to
 * specific action assigned to this value (e.g 0. Cancel action)
 * <p>
 * This class responds to sout order content (quantity, extra option).
 *
 * @author Dawid Janik
 */
@UtilityClass
public class OrderView {

    public static void orderLaunchView() {
        CommonPurposeView.viewSystemInfo();

        System.out.println(" 1.Quantity ");
        //System.out.println(" 2.Accept ");
        System.out.println();
        System.out.println(" 0.Cancel ");

        Engine.makeActionLaunchOrder();
    }

    public static void orderDrinkView() {
        CommonPurposeView.viewSystemInfo();

        System.out.println(" 1.Quantity ");
        System.out.println(" 2. Extra Lemon "); // +L
        System.out.println(" 3. Extra Ice cubes "); // +Ice
        System.out.println(" 4. Extra Lemon + Ice cubes "); // Lemon + Ice
        // System.out.println(" 5.Accept "); // For future purpose
        System.out.println();
        System.out.println(" 0.Cancel ");

        Engine.makeActionDrinkOrder();
    }

    public static void quantityView() {
        CommonPurposeView.viewSystemInfo();
        System.out.print(" Quantity: "); // Here take quantity
        System.out.println();
        System.out.println(" 0.Cancel ");

        Engine.makeQuantityAdd();
    }

}
