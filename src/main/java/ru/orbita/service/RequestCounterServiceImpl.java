package ru.orbita.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.orbita.dao.RequestCounterDao;

@Service
public class RequestCounterServiceImpl implements RequestCounterService {

    private RequestCounterDao dao;

    public RequestCounterServiceImpl(RequestCounterDao dao) {
        this.dao = dao;
    }

    @Transactional
    @Override
    public long increment() {
        return dao.incrementInDB();  //инкремент на стороне DB , тест проходит быстрее
//        return dao.increment();   //инкремент на стороне приложения
    }

    @Transactional(readOnly = true)
    @Override
    public long get() {
        return dao.getCounter();
    }

    @Transactional
    @Override
    public void resetCounter() {
        dao.resetCounter();
    }

    @Transactional
    @Override
    public void init() {
        dao.init();
    }
}
