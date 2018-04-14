package pl.ordersys.core.restaurant;

/**
 * @author Dawid Janik
 * @since 14.04.2018
 */
public interface ViewEngine {

    /**
     * These kind of methods are used to launch proper
     * application console view and make action if
     * need to.
     */
    void makeActionOnGlobalView();

    void makeActionOnMainView();

    void makeActionManageView();
}
