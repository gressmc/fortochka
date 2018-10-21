package com.gress.fortochka.services;

import com.gress.fortochka.model.Photo;
import com.gress.fortochka.repositories.PhotoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Roman_Radetskiy.
 */
@Service
@Transactional
public class PhotoService implements AbstractService<Photo> {

    PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public Photo getItemById(Long id) {
        return photoRepository.findById(id).orElse(null);
    }

    @Override
    public Photo getItemByProp(String code) {
        return photoRepository.findByCode(code);
    }

    @Override
    public Iterable<Photo> findAll() {
        return photoRepository.findAll();
    }
}