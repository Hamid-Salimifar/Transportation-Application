package ir.maktabsharif.transportationapplication.service.impl;

import ir.maktabsharif.transportationapplication.service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class BaseServiceImpl<T> implements BaseService<T> {

    private final JpaRepository<T,Integer> jpaRepository;

    public BaseServiceImpl(JpaRepository<T, Integer> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public T saveOrUpdate(T entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public T findById(Integer id) {
        return jpaRepository.findById(id).orElseThrow();
    }

    @Override
    public List<T> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        jpaRepository.deleteById(id);
    }
}
