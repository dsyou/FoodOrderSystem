package pl.ordersys.core.content;

import lombok.*;

/**
 * This class represents each "Cuisine"
 *
 * @author Dawid Janik
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Cuisine {
    private String name;
    private Course course;
    private Drink dessert;
}
