package com.gress.fortochka.services;


/**
 * @author Roman_Radetskiy.
 */
public interface AbstractService<T> {

    T getItemById(Long id);
    T getItemByProp(String prop);
    Iterable<T> findAll();
}
