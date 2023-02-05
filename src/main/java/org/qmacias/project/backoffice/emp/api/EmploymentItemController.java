package org.qmacias.project.backoffice.emp.api;

import org.qmacias.project.backoffice.emp.domain.EmploymentItem;
import org.qmacias.project.backoffice.emp.application.EmploymentItemService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employment")
final class EmploymentItemController {

    private final EmploymentItemService service;

    EmploymentItemController(final EmploymentItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmploymentItem> allEmploymentItems() {
        return service.all();
    }

    @GetMapping("/{id}")
    public EmploymentItem getEmploymentItem(@PathVariable final Long id) {
        return service.get(id);
    }

    @PostMapping
    public EmploymentItem addEmploymentItem(@RequestBody final EmploymentItem employmentItem) {
        return service.add(employmentItem);
    }

    @DeleteMapping("/{id}")
    public void removeEmploymentItem(@PathVariable final Long id) {
        service.remove(id);
    }

}
