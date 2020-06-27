package ru.orbita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.orbita.service.RequestCounterService;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RequestCounterApplication {

    private RequestCounterService service;


    public RequestCounterApplication(RequestCounterService service) {
        this.service = service;
    }

    @PostConstruct
    void init() {
        service.init();
    }

    public static void main(String[] args) {
        SpringApplication.run(RequestCounterApplication.class, args);

    }
}
