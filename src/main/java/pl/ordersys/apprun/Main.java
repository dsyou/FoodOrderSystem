package pl.ordersys.apprun;


import lombok.extern.slf4j.Slf4j;
import pl.ordersys.core.DataContent;
import pl.ordersys.view.GeneralView;

/**
 * <h1>Food Ordering System<h1/>
 * The Fod Ordering System implements an application that
 * provide restaurant ordering system with special requirements,
 * describe in readme.md file.
 *
 * @author Dawid Janik
 */
@Slf4j
public class Main {

    private static String path = "./resources/Food.xls";

    /**
     * This is the main method that launches thread of Application,
     * and also is trying to take object from Excel file (which keep all restaurant data).
     * After successful operation this method launch General View of command-line interface.
     *
     * @param args unused or used depends of method giving a initial path of Excel file.
     */
    public static void main(String[] args) {
        if (args.length != 0) {
            path = args[0];
        }
        ThreadApp threadApp = new ThreadApp();
        threadApp.start();
        DataContent.getContent(path);
        GeneralView.view();
    }
}
