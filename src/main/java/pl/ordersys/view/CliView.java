package pl.ordersys.view;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.ordersys.core.Engine;

/**
 * @author Dawid Janik
 * @since 02.04.2018
 */
@Component
public abstract class CliView {

    public Engine getEngine() {
        return new Engine();
    }

    public abstract void view();
}
