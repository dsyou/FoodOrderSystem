package pl.ordersys.core.content;

import lombok.*;

/**
 * This class contains representations of the each object "Drink"
 *
 * @author Dawid Janik
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Drink {
    private String name;
    private double price;
}
