package org.example.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    public List<T> findAll();
    public T findById(int id);
    public void save(T t);
    public void delete(T t);
    public void update(T t);

}
