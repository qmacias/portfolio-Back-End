package org.qmacias.project.portfolio.cer.api;

import org.qmacias.project.portfolio.cer.domain.Certification;
import org.qmacias.project.portfolio.cer.application.CertificationService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certification")
final class CertificationController {

    private final CertificationService service;

    CertificationController(final CertificationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Certification> allCertification() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Certification getCertification(@PathVariable final String id) {
        return service.get(id);
    }

    @PostMapping
    public Certification addCertification(@RequestBody final Certification certification) {
        return service.add(certification);
    }

    @DeleteMapping("/{id}")
    public void removeCertification(@PathVariable final String id) {
        service.remove(id);
    }

}
