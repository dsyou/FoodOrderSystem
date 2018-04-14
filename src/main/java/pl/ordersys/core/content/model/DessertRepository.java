package pl.ordersys.core.content.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ordersys.core.content.model.jpa.Dessert;

/**
 * @author Dawid Janik
 * @since 14.04.2018
 */
@Repository
public interface DessertRepository extends JpaRepository<Dessert, Long> {
}
