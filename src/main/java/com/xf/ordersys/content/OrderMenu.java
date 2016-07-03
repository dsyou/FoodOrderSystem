package com.xf.ordersys.content;

import java.util.LinkedList;

/**
 * Created by Dawid Janik on 2016-06-29.
 *@author Dawid Janik
 *
 *
 *
 */
public class OrderMenu {


    private static OrderMenu instance = null;

    private LinkedList<Cuisines> arrayOfCuisine = null; // tablica Kuchni
    private LinkedList<Drinks>   arrayOfDrinks = null; //  tablica Drinkow

    public int userKey = 0;
    public int t = 0;

    private boolean menu_check;

//=================================================================================================================
//Getter and Setter

    public static OrderMenu getInstance() {
        return instance;
    }

    public static void setInstance(OrderMenu instance) {
        OrderMenu.instance = instance;
    }

    public LinkedList<Cuisines> getArrayOfCuisine() {
        return arrayOfCuisine;
    }

    public void setArrayOfCuisine(LinkedList<Cuisines> arrayOfCuisine) {
        this.arrayOfCuisine = arrayOfCuisine;
    }

    public LinkedList<Drinks> getArrayOfDrinks() {
        return arrayOfDrinks;
    }

    public void setArrayOfDrinks(LinkedList<Drinks> arrayOfDrinks) {
        this.arrayOfDrinks = arrayOfDrinks;
    }

    public void setMenu_check(boolean menu_check) {
        this.menu_check = menu_check;
    }

    public boolean isMenu_check() {
        return menu_check;
    }
//=================================================================================================================
//Method Singleton

    public static OrderMenu getInstace(){

        if (instance==null){

            instance= new OrderMenu();

        }
        return instance;
    }

//=================================================================================================================
//Another Methods

//    public int get


} // end of OrderMenu
