package ir.maktabsharif.transportationapplication.service;

import java.util.List;

public interface BaseService<T> {
    T saveOrUpdate(T entity);
    T findById(Integer id);
    List<T> findAll();
    void deleteById(Integer id);
}
