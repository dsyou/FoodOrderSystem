package pl.ordersys.core.content.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ordersys.core.content.model.jpa.Drink;

import java.util.List;
import java.util.Optional;

/**
 * @author Dawid Janik
 * @since 14.04.2018
 */
@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {

    Optional<Drink> findById(long id);

    List<Optional<Drink>> getAll();

}
