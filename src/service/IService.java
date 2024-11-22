package service;

import java.util.List;

public interface IService<T> {
    List<T> getAll();

    void save(T s);

    void update(long phone, T s);

    void remove(long phone);

    T findByPhone(long phone);

    List<T> findByName(String name);

}
