package com.xf.ordersys.exception;

/**
 * Created by XCVB on 2016-06-27.
 * @author Dawid Janik
 *
 *
 *
 */
public class AppExp extends Exception{


//===================================================================
//()

    public AppExp(String message) {
        super(message);
    }

    public AppExp(String message, Throwable cause) {
        super(message, cause);
    }
}
