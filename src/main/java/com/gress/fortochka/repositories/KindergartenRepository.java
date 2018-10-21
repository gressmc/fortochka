package com.gress.fortochka.repositories;

import com.gress.fortochka.model.Kindergarten;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Roman_Radetskiy.
 */
public interface KindergartenRepository extends CrudRepository<Kindergarten, Long> {
    Kindergarten findByTitle(String title);
}
