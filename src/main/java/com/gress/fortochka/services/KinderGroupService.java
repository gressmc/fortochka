package com.gress.fortochka.services;

import com.gress.fortochka.model.Kindergroup;
import com.gress.fortochka.repositories.KinderGroupRepository;
import org.springframework.stereotype.Service;

/**
 * @author Roman_Radetskiy.
 */
@Service
public class KinderGroupService implements AbstractService<Kindergroup> {

    KinderGroupRepository kinderGroupRepository;

    public KinderGroupService(KinderGroupRepository kinderGroupRepository) {
        this.kinderGroupRepository = kinderGroupRepository;
    }

    @Override
    public Kindergroup getItemById(Long id) {
        return kinderGroupRepository.findById(id).orElse(null);
    }

    @Override
    public Kindergroup getItemByProp(String title) {
        return kinderGroupRepository.findByTitle(title);
    }

    @Override
    public Iterable<Kindergroup> findAll() {
        return kinderGroupRepository.findAll();
    }
}
