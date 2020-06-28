package ru.orbita.service;

public interface RequestCounterService {

    long increment();

    long get();

    void resetCounter();

    void init();
}
