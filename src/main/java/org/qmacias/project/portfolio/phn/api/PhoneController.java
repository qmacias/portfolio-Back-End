package org.qmacias.project.portfolio.phn.api;

import org.qmacias.project.portfolio.phn.domain.Phone;
import org.qmacias.project.portfolio.phn.application.PhoneService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/phone")
final class PhoneController {

    private final PhoneService service;

    PhoneController(final PhoneService service) {
        this.service = service;
    }

    @GetMapping
    public List<Phone> allPhones() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Phone getPhone(@PathVariable final Long id) {
        return service.get(id);
    }

    @PostMapping
    public Phone addPhone(@RequestBody final Phone phone) {
        return service.add(phone);
    }

    @DeleteMapping("/{id}")
    public void removePhone(@PathVariable final Long id) {
        service.remove(id);
    }

}
