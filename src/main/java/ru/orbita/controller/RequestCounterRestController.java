package ru.orbita.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.orbita.model.RequestCounter;
import ru.orbita.service.RequestCounterService;

@RestController
@RequestMapping("/")
public class RequestCounterRestController {

    private RequestCounterService service;

    public RequestCounterRestController(RequestCounterService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<RequestCounter> increment() {
//        return new ResponseEntity<>(service.increment(), HttpStatus.OK);
        return ResponseEntity.ok(service.increment());
    }

    @GetMapping
    ResponseEntity<RequestCounter> getRequestCounter() {
        return ResponseEntity.ok(service.get());

    }

    @DeleteMapping
    String deleteRequestCounter() {
        service.resetCounter();
        return "counter is reset";

    }
}
