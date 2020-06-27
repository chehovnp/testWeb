package ru.orbita.dao;

import org.springframework.stereotype.Repository;
import ru.orbita.model.RequestCounter;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

@Repository
public class RequestCounterDaoImpl implements RequestCounterDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public RequestCounter increment() {
        RequestCounter requestCounter = entityManager.createQuery("SELECT u FROM RequestCounter u", RequestCounter.class).setLockMode(LockModeType.PESSIMISTIC_WRITE).getSingleResult();
        requestCounter.setCounter(requestCounter.getCounter() + 1);
        return entityManager.merge(requestCounter);

    }

    @Override
    public RequestCounter get() {
        return entityManager.createQuery("SELECT u FROM RequestCounter u", RequestCounter.class).getSingleResult();
    }

    @Override
    public void resetCounter(RequestCounter requestCounter) {
        entityManager.merge(requestCounter);

    }

    @Override
    public void init() {
        if (entityManager.createQuery("SELECT u FROM RequestCounter u", RequestCounter.class).getResultList().size() == 0) {
            entityManager.persist(new RequestCounter());
        }

    }
}
