package pl.ordersys.content;

import lombok.*;

/**
 * This class contains representations of the each object "Drinks"
 *
 * @author Dawid Janik
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Drinks {
    private String name;
    private double price;
}
