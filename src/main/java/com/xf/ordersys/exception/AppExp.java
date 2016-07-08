package com.xf.ordersys.exception;

/**
 * Signals that a method has been invoked at an illegal or
 * inappropriate time.
 * This class is used to future purpose (e.g define specific way to shutdown application
 *  or save current order state).
 *
 *
 * @author Dawid Janik
 */
public class AppExp extends Exception{


//===================================================================
//Constructs()

    /**
     * Constructs an AppExp with the specified detail
     * message.  A detail message is a String that describes this particular
     * exception.
     *
     * @param message
     */
    public AppExp(String message) {
        super(message);
    }

    public AppExp(String message, Throwable cause) {
        super(message, cause);
    }


}
