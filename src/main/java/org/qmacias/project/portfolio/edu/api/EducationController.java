package org.qmacias.project.portfolio.edu.api;

import lombok.RequiredArgsConstructor;

import org.qmacias.project.backoffice.mod.application.ModalityService;
import org.qmacias.project.backoffice.mod.domain.Modality;
import org.qmacias.project.portfolio.cer.application.CertificationService;
import org.qmacias.project.portfolio.cer.domain.Certification;
import org.qmacias.project.portfolio.img.domain.Image;
import org.qmacias.project.backoffice.cat.domain.Category;
import org.qmacias.project.portfolio.edu.domain.Education;
import org.qmacias.project.portfolio.img.application.ImageService;
import org.qmacias.project.portfolio.edu.application.EducationService;
import org.qmacias.project.backoffice.cat.application.CategoryService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/education")
final class EducationController {

    private final EducationService service;

    private final ImageService imageService;

    private final CategoryService categoryService;

    private final ModalityService modalityService;

    private final CertificationService certificationService;

    @GetMapping
    public List<Education> allEducation() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Education getEducation(@PathVariable final Long id) {
        return service.get(id);
    }

    @PostMapping
    public Education addEducation(@RequestBody final Education education) {
        return service.add(education);
    }

    @DeleteMapping("/{id}")
    public void removeEducation(@PathVariable final Long id) {
        service.remove(id);
    }

    @PutMapping("/{id}/image_detail/{imageId}")
    public Education assignImageDetail(@PathVariable final Long id, @PathVariable final Long imageId) {
        final Image image = imageService.get(imageId);
        return service.assignImage(id, image);
    }

    @PutMapping("/{id}/category_detail/{categoryId}")
    public Education assignCategoryDetail(@PathVariable final Long id, @PathVariable final Long categoryId) {
        final Category category = categoryService.get(categoryId);
        return service.assignCategory(id, category);
    }

    @PutMapping("/{id}/modality_detail/{modalityId}")
    public Education assignModalityDetail(@PathVariable final Long id, @PathVariable final Long modalityId) {
        final Modality modality = modalityService.get(modalityId);
        return service.assignModality(id, modality);
    }

    @PutMapping("/{id}/certification_detail/{certificationId}")
    public Education assignCertificationDetail(@PathVariable final Long id, @PathVariable final String certificationId) {
        final Certification certification = certificationService.get(certificationId);
        return service.assignCertification(id, certification);
    }

}
