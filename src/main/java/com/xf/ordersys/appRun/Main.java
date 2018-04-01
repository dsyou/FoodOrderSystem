package com.xf.ordersys.appRun;


import com.xf.ordersys.core.DataContent;
import com.xf.ordersys.exception.AppExp;
import com.xf.ordersys.view.GeneralView;

/**
 * <h1>Food Ordering System<h1/>
 * The Fod Ordering System implements an application that
 * provide restaurant ordering system with special requirements,
 * describe in readme.md file.
 *
 * @author Dawid Janik
 */
public class Main {

    public static String path = "";

    /**
     * This is the main method that launches thread of Application,
     * and also is trying to take object from Excel file (which keep all restaurant data).
     * After successful operation this method launch General View of command-line interface.
     *
     * @param args unused or used depends of method giving a initial path of Excel file.
     * @throws Exception I/0 exception
     */
    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            path = "C://Food.xlsx"; // Default path
        } else {
            path = args[0];
        }
        ThreadApp t = new ThreadApp();
        t.start();

        try {
            DataContent.getContent(path); // Place of  path take from args  //"C://Food.xlsx" or not
        } catch (AppExp appExp) {
            appExp.printStackTrace();
        }
        GeneralView.view();

    }

}
