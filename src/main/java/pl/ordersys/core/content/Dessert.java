package pl.ordersys.core.content;

import lombok.*;

/**
 * @author Dawid Janik
 * @since 07.04.2018
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Dessert {
    private String name;
    private double price;
}
