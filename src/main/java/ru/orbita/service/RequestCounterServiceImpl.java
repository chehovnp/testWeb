package ru.orbita.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.orbita.dao.RequestCounterDao;
import ru.orbita.model.RequestCounter;

@Service
public class RequestCounterServiceImpl implements RequestCounterService {

    private RequestCounterDao dao;

    public RequestCounterServiceImpl(RequestCounterDao dao) {
        this.dao = dao;
    }

    @Transactional
    @Override
    public RequestCounter increment() {
        return dao.increment();
    }

    @Transactional(readOnly = true)
    @Override
    public RequestCounter get() {
        return dao.get();
    }

    @Transactional
    @Override
    public void resetCounter() {
       RequestCounter requestCounter= dao.get();
       requestCounter.setCounter(0);
        dao.resetCounter(requestCounter);
    }

    @Transactional
    @Override
    public void init() {
        dao.init();
    }
}
