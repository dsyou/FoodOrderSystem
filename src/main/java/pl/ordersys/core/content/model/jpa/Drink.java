package pl.ordersys.core.content.model.jpa;

import lombok.*;
import pl.ordersys.core.content.model.jpa.core.JpaIdEntity;

import javax.persistence.*;

/**
 * @author Dawid Janik
 * @since 14.04.2018
 */
@Data
@Entity
@Table(name = "drinks")
public class Drink  extends JpaIdEntity {
    private String name;
    private double price;
}
