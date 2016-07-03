package com.xf.ordersys.appRun;


import com.xf.ordersys.core.DataContent;
import com.xf.ordersys.view.GeneralView;

import java.io.IOException;

/**
 * @author Dawid Janik
 */
public class Main {

    public static void main(String[] args) throws IOException {

        ThreadApp t = new ThreadApp();
        t.start();

        DataContent.getContent("C://Food.xlsx"); // Place of ... path take from args ?

        GeneralView.view();

    }


  //TODO ...
    // 1.Tylko commnad-line interface

    // 2. Moge zamowic tylko lunch albo drink przez interfejs

    // 3. Sa trzy kuchnie

    // 4. Lunch zawiera glowne danie i deser

    //5. Drink  uzytkownik moze poprosic dodatkowo o lemonke : ) , albo bez limony

    //6. getPrice() getName()

    // 7. Solution must be extendable



}
