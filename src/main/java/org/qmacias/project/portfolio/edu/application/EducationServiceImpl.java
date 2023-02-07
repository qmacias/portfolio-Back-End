package org.qmacias.project.portfolio.edu.application;

import org.qmacias.project.backoffice.mod.domain.Modality;
import org.qmacias.project.portfolio.cer.domain.Certification;
import org.qmacias.project.portfolio.img.domain.Image;
import org.qmacias.project.backoffice.cat.domain.Category;
import org.qmacias.project.portfolio.edu.domain.Education;
import org.qmacias.project.portfolio.edu.domain.EducationRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EducationServiceImpl implements EducationService {

    private final EducationRepository repository;

    public EducationServiceImpl(final EducationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Education> all() {
        return repository.findAll();
    }

    @Override
    public Education get(final Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Education add(final Education education) {
        return repository.save(education);
    }

    @Override
    public void remove(final Long id) {
        repository.deleteById(id);
    }

    @Override
    public Education assignImage(final Long id, final Image image) {
        final Education education = this.get(id);
        education.setImage(image);
        return this.add(education);
    }

    @Override
    public Education assignCategory(final Long id, final Category category) {
        final Education education = this.get(id);
        education.setCategory(category);
        return this.add(education);
    }

    @Override
    public Education assignModality(final Long id, final Modality modality) {
        final Education education = this.get(id);
        education.setModality(modality);
        return this.add(education);
    }

    @Override
    public Education assignCertification(final Long id, final Certification certification) {
        final Education education = this.get(id);
        education.setCertification(certification);
        return this.add(education);
    }

}
