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

    // инкремент на стороне dao
    @Override
    public long increment() {
        RequestCounter requestCounter = entityManager.createQuery("SELECT u FROM RequestCounter u", RequestCounter.class).setLockMode(LockModeType.PESSIMISTIC_WRITE).getSingleResult();
        requestCounter.setCounter(requestCounter.getCounter() + 1);
        return entityManager.merge(requestCounter).getCounter();
    }

    // инкремент на стороне базы
    @Override
    public long incrementInDB() {
        entityManager.createQuery("UPDATE  RequestCounter u SET u.counter= u.counter+1").executeUpdate();
        return getCounter();
    }

    @Override
    public long getCounter() {
        return entityManager.createQuery("SELECT u.counter FROM RequestCounter u where u.id=0", Long.class).getSingleResult();
    }

    @Override
    public void resetCounter() {
        entityManager.createQuery("UPDATE  RequestCounter SET counter= 0").executeUpdate();
    }

    @Override
    public void init() {
        if (entityManager.createQuery("SELECT u FROM RequestCounter u", RequestCounter.class).getResultList().size() == 0) {
            entityManager.persist(new RequestCounter());
        }

    }
}
