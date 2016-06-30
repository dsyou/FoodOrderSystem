package com.xf.ordersys.appRun;

/**
 * Created by Dawid Janik on 2016-06-28.
 */
public class ThreadApp extends Thread{

    boolean run;

    public ThreadApp() {
        super();
    }

    public void  run(){
        run = true;

        while (run){

            //System.out.println("Thread is Running");
        }



    }


}
