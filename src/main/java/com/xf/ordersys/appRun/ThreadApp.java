package com.xf.ordersys.appRun;

import com.xf.ordersys.content.OrderMenu;

/**
 * Created by Dawid Janik on 2016-06-28.
 *
 *
 *
 */
public class ThreadApp extends Thread{

    OrderMenu o = OrderMenu.getInstace();

    boolean run;

    public ThreadApp() {
        super();
    }

    public void  run(){
        run = true;

        while (run){

            if (o.userKey == 999)
                System.exit(0);

            //System.out.println("Thread is Running");
        }

        //TODO Exception -> General View

    }


}
