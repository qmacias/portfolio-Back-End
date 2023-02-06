package org.qmacias.project.portfolio.phn.application;

import org.qmacias.project.portfolio.phn.domain.Phone;
import org.qmacias.project.portfolio.phn.domain.PhoneRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository repository;

    public PhoneServiceImpl(final PhoneRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Phone> all() {
        return repository.findAll();
    }

    @Override
    public Phone get(final Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Phone add(final Phone phone) {
        return repository.save(phone);
    }

    @Override
    public void remove(final Long id) {
        repository.deleteById(id);
    }

}
