package vn.edu.iuh.fit.backend.repositories;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T, ID> {
    Optional<T> findById(ID id);
    List<T> findAll();

    boolean save(T entity);

    boolean update(T entity);

    boolean delete(ID id);

}
