package ru.orbita.service;

import ru.orbita.model.RequestCounter;

public interface RequestCounterService {

    RequestCounter increment();

    RequestCounter get();

    void resetCounter();

    void init();
}
