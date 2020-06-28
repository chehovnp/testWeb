package ru.orbita.dao;

public interface RequestCounterDao {

    long increment();

    long incrementInDB();

    void resetCounter();

    void init();

    long getCounter();

}
