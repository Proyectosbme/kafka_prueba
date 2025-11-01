package com.resolutions.aplicacion.ports.out;

import java.util.List;

public interface IDataPersist<T> {
    T guardar(T dto);

    void update(T dto);

    void delete(T dto);

    T get(String cod);

    List<T> getAll();

    long count();
}
