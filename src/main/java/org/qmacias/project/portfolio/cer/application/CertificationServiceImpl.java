package org.qmacias.project.portfolio.cer.application;

import org.qmacias.project.portfolio.cer.domain.Certification;

import org.qmacias.project.portfolio.cer.domain.CertificationRepository;
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

}
