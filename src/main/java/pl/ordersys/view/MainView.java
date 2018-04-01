package pl.ordersys.view;

import pl.ordersys.core.Engine;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric values responsible to
 * specific action assigned to this value (e.g 5. Back to previous view)
 *
 * This class responds to sout Main view order content.
 *
 * @author Dawid Janik
 */
public class MainView {

    public MainView(){
        super();
    }

    public static void view(){

        CommonPurposeView.view_SystemInfo();

        System.out.println(" 1.Lunch");
        System.out.println(" 2.Drink's");
        CommonPurposeView.totalAmount();     //System.out.println("    Total Amount: ");

        System.out.println(" 4.Show/Forgot Order");
        System.out.println(" 5.Back");

        Engine.makeActionMainView();
    }

}
