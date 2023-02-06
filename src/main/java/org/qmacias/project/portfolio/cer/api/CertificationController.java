package org.qmacias.project.portfolio.cer.api;

import lombok.RequiredArgsConstructor;
import org.qmacias.project.portfolio.cer.domain.Certification;
import org.qmacias.project.portfolio.cer.application.CertificationService;

import org.qmacias.project.portfolio.img.application.ImageService;
import org.qmacias.project.portfolio.img.domain.Image;
import org.qmacias.project.portfolio.proj.domain.Project;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/certification")
final class CertificationController {

    private final CertificationService service;

    private final ImageService imageService;

    @GetMapping
    public List<Certification> allCertifications() {
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

    @PutMapping("/{id}/certification_detail/{imageId}")
    public Certification assignImageDetail(@PathVariable final String id, @PathVariable final Long imageId) {
        final Image image = imageService.get(imageId);
        return service.assignImage(id, image);
    }

}
