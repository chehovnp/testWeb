package ru.orbita.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class RequestCounterServiceImplTest {
    @Autowired
    private RequestCounterServiceImpl service;

    @Test
    void resetCounter() {
        service.resetCounter();
        Assertions.assertEquals(service.get(), 0);
    }

    @Test
    void incrementAndGet() throws InterruptedException {

        service.resetCounter();

        Thread thread = new Thread(new Run());
        Thread thread1 = new Thread(new Run());
        Thread thread2 = new Thread(new Run());
        Thread thread3 = new Thread(new Run());

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();

        thread.join();
        thread1.join();
        thread2.join();
        thread3.join();

        Assertions.assertEquals(service.get(), 12000);
    }

//    @Test
//    void get_ResetCounter_Increment() throws InterruptedException {
//        resetCounter();
//        increment();
//        Assertions.assertEquals(service.get(),12000);
//    }


    @Test
    void init() {
    }

    class Run implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            for (int i = 0; i < 3000; i++)
                service.increment();
        }
    }
}