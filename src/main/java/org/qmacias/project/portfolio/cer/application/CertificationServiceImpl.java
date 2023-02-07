package org.qmacias.project.portfolio.cer.application;

import org.qmacias.project.backoffice.cat.domain.Category;
import org.qmacias.project.portfolio.cer.domain.Certification;
import org.qmacias.project.portfolio.cer.domain.CertificationRepository;

import org.qmacias.project.portfolio.img.domain.Image;
import org.qmacias.project.portfolio.proj.domain.Project;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CertificationServiceImpl implements CertificationService {

    private final CertificationRepository repository;

    public CertificationServiceImpl(final CertificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Certification> all() {
        return repository.findAll();
    }

    @Override
    public Certification get(final String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Certification add(final Certification certification) {
        return repository.save(certification);
    }

    @Override
    public void remove(final String id) {
        repository.deleteById(id);
    }

    @Override
    public Certification assignImage(final String id, final Image image) {
        final Certification certification = this.get(id);
        certification.setImage(image);
        return this.add(certification);
    }

    @Override
    public Certification assignCategory(final String id, final Category category) {
        final Certification certification = this.get(id);
        certification.setCategory(category);
        return this.add(certification);
    }

}
