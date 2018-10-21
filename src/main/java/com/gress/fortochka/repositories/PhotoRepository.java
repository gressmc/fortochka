package com.gress.fortochka.repositories;

import com.gress.fortochka.model.Photo;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Roman_Radetskiy.
 */
public interface PhotoRepository extends CrudRepository<Photo, Long> {
    Photo findByCode(String code);
}
