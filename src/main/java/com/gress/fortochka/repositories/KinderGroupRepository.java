package com.gress.fortochka.repositories;

import com.gress.fortochka.model.Kindergroup;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Roman_Radetskiy.
 */
public interface KinderGroupRepository extends CrudRepository<Kindergroup, Long> {

    Kindergroup findByTitle(String title);
}
