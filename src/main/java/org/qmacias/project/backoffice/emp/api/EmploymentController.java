package org.qmacias.project.backoffice.emp.api;

import org.qmacias.project.backoffice.emp.domain.Employment;
import org.qmacias.project.backoffice.emp.application.EmploymentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employment")
final class EmploymentController {

    private final EmploymentService service;

    EmploymentController(final EmploymentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employment> allEmployments() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Employment getEmployment(@PathVariable final Long id) {
        return service.get(id);
    }

    @PostMapping
    public Employment addEmployment(@RequestBody final Employment employment) {
        return service.add(employment);
    }

    @DeleteMapping("/{id}")
    public void removeEmployment(@PathVariable final Long id) {
        service.remove(id);
    }

}
