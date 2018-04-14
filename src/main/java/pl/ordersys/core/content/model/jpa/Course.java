package pl.ordersys.core.content.model.jpa;

import lombok.*;
import pl.ordersys.core.content.model.jpa.core.JpaIdEntity;

import javax.persistence.*;

/**
 * @author Dawid Janik
 * @since 07.04.2018
 */
@Data
@Entity
@Table(name = "courses")
public class Course extends JpaIdEntity {

    private String name;
    private double price;
    private Dessert dessert;
}
