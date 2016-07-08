package com.xf.ordersys.view;

import com.xf.ordersys.core.Engine;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric value responsible to
 * specific action assigned to this value (e.g 3. Exit)
 *
 * This class responds to sout general command line view.
 *
 * @author Dawid Janik
 */
public class GeneralView {


    public static void view(){

        CommonPurposeView.view_SystemInfo();

        System.out.println(" 1. Make Order" );
        System.out.println(" 2. Payment");
        System.out.println();
        System.out.println(" 3. Exit");

        Engine.makeAction_globalView();

    }

}
