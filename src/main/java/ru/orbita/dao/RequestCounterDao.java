package ru.orbita.dao;

import ru.orbita.model.RequestCounter;

public interface RequestCounterDao {

    RequestCounter increment();

    RequestCounter get();

    void resetCounter(RequestCounter requestCounter);

    void init();
}
