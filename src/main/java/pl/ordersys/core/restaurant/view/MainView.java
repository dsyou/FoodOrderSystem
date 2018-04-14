package pl.ordersys.core.restaurant.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * View class describes the menu of command line interfaces
 * Each position contains numeric values responsible to
 * specific action assigned to this value (e.g 5. Back to previous view)
 * <p>
 * This class responds to sout Main view order content.
 *
 * @author Dawid Janik
 */
@Component
//@NoArgsConstructor(onConstructor = @__(@Autowired))
public class MainView {

    public void view() {
        UtilityView.viewSystemInfo();

        System.out.println(" 1.Lunch");
        System.out.println(" 2.Drink's");
        UtilityView.totalAmount();

        System.out.println(" 4.Show/Forgot Order");
        System.out.println(" 5.Back");

//        getEngine().makeActionOnMainView();
//        getEngine().makeActionOnMainView();
    }

    @Autowired
    public MainView() {
    }
}
