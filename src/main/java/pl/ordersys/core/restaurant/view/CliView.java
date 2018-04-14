package pl.ordersys.core.restaurant.view;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.ordersys.core.restaurant.Engine;

/**
 * @author Dawid Janik
 * @since 02.04.2018
 */
@Component
@NoArgsConstructor
public abstract class CliView {

    public Engine getEngine() {
        return null; // new Engine();
    }

    public abstract void view();
}
