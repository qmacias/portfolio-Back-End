package org.qmacias.project.backoffice.mod.api;

import org.qmacias.project.backoffice.mod.domain.Modality;
import org.qmacias.project.backoffice.mod.application.ModalityService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modality")
final class ModalityController {

    private final ModalityService service;

    public ModalityController(final ModalityService service) {
        this.service = service;
    }

    @GetMapping
    public List<Modality> allModalities() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Modality getModality(@PathVariable final Long id) {
        return service.get(id);
    }

    @PostMapping
    public Modality addModality(@RequestBody final Modality modality) {
        return service.add(modality);
    }

    @DeleteMapping("/{id}")
    public void removeModality(@PathVariable final Long id) {
        service.remove(id);
    }

}
