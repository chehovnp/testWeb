package ru.orbita.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RequestCounter {

@Id
private long id;

private long counter;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public RequestCounter() {
    }

    @Override
    public String toString() {
        return "counter="+counter;
    }
}
