package com.xf.ordersys.view;

import com.xf.ordersys.core.Engine;

/**
 * Created by Dawid Janik on 2016-06-28.
 *
 *
 *
 */
public class MangeOrderVIew {

    public MangeOrderVIew() {
    }

    public static void view() {

        CommonPurposeView.view_SystemInfo();
        System.out.println(" 1.Show Order");
        System.out.println(" 5.Forgot Order");
        System.out.println();
        System.out.println(" 0.Cancel");

        Engine.makeAction_manageView();
    }


}
