package org.qmacias.project.portfolio.per.api;

import lombok.RequiredArgsConstructor;
import org.qmacias.project.portfolio.job.application.JobService;
import org.qmacias.project.portfolio.job.domain.Job;
import org.qmacias.project.portfolio.per.application.PersonService;

import org.qmacias.project.portfolio.per.domain.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
final class PersonController {

    private final PersonService service;

    private final JobService jobService;

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

    @PutMapping("/{id}/job/{jobId}")
    public Person addJobItem(@PathVariable final Long id, @PathVariable final Long jobId) {
        final Job job = jobService.get(jobId);
        return service.addJobItem(id, job);
    }

    @PutMapping("/{id}/remove_job/{jobId}")
    public Person removeJobItem(@PathVariable final Long id, @PathVariable final Long jobId) {
        final Job job = jobService.get(jobId);
        return service.removeJobItem(id, job);
    }

}
