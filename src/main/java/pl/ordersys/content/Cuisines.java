package pl.ordersys.content;

import lombok.*;

/**
 * This class contains representations of the each object "Cuisines"
 *
 * @author Dawid Janik
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Cuisines {
    private Double price;
    private String nameCuisines;
    private String nameMainCourse;
    private String nameDessert;
}
