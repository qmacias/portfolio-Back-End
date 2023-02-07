package org.qmacias.project.portfolio.per.api;

import org.qmacias.project.portfolio.job.domain.Job;
import org.qmacias.project.portfolio.per.application.PersonService;

import org.qmacias.project.portfolio.per.domain.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
final class PersonController {

    private final PersonService service;

    PersonController(final PersonService service) {
        this.service = service;
    }

    @GetMapping
    public List<Person> allPerson() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable final Long id) {
        return service.get(id);
    }

    @PostMapping
    public Person addPerson(@RequestBody final Person person) {
        return service.add(person);
    }

    @DeleteMapping("/{id}")
    public void removePerson(@PathVariable final Long id) {
        service.remove(id);
    }

}
