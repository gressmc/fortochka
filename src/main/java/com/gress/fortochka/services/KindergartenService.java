package com.gress.fortochka.services;

import com.gress.fortochka.model.Kindergarten;
import com.gress.fortochka.model.Kindergroup;
import com.gress.fortochka.repositories.KindergartenRepository;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    public Kindergarten create(String title, String[] groups){
        Kindergarten newKindergarten = new Kindergarten();
        newKindergarten.setTitle(title);
//        Arrays.stream(groups).forEach(Kindergroup::new);
        List<String> l = Arrays.asList(groups);
        for (String t: l) {
            Kindergroup kindergroup = new Kindergroup();
            kindergroup.setTitle(t);
            kindergroup.setKindergarten(newKindergarten);
        }

        kindergartenRepository.save(newKindergarten);
        return newKindergarten;
    }
}
