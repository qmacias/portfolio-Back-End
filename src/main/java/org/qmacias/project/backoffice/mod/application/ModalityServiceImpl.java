package org.qmacias.project.backoffice.mod.application;

import org.qmacias.project.backoffice.mod.domain.Modality;
import org.qmacias.project.backoffice.mod.domain.ModalityRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ModalityServiceImpl implements ModalityService {

    private final ModalityRepository repository;

    public ModalityServiceImpl(final ModalityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Modality> all() {
        return repository.findAll();
    }

    @Override
    public Modality get(final Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Modality add(final Modality modality) {
        return repository.save(modality);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

}
