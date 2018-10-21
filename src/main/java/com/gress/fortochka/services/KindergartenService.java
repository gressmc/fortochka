package com.gress.fortochka.services;

import com.gress.fortochka.model.Kindergarten;
import com.gress.fortochka.repositories.KindergartenRepository;
import org.springframework.stereotype.Service;

/**
 * @author Roman_Radetskiy.
 */
@Service
public class KindergartenService implements AbstractService<Kindergarten> {

    KindergartenRepository kindergartenRepository;

    public KindergartenService(KindergartenRepository kindergartenRepository) {
        this.kindergartenRepository = kindergartenRepository;
    }

    @Override
    public Kindergarten getItemById(Long id) {
        return kindergartenRepository.findById(id).orElse(null);
    }

    @Override
    public Kindergarten getItemByProp(String title) {
        return kindergartenRepository.findByTitle(title);
    }

    @Override
    public Iterable<Kindergarten> findAll() {
        return kindergartenRepository.findAll();
    }
}
