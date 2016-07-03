package com.xf.ordersys.appRun;


import com.xf.ordersys.core.DataContent;
import com.xf.ordersys.exception.AppExp;
import com.xf.ordersys.view.GeneralView;

/**
 * @author Dawid Janik
 *
 *
 *
 */
public class Main {

    public static String path = "";

    public static void main(String[] args) throws Exception {

        if(args.length == 0 ){
            path = "C://Food.xlsx"; // Default path
        }else{
            path = args[0];
        }
        ThreadApp t = new ThreadApp();
        t.start();

        try {
            DataContent.getContent(path); // Place of  path take from args  //"C://Food.xlsx"
        } catch (AppExp appExp) {
            appExp.printStackTrace();
        }
        GeneralView.view();

    }



} // End of Main Class
