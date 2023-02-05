package org.qmacias.project.backoffice.emp.application;

import org.qmacias.project.backoffice.emp.domain.Employment;
import org.qmacias.project.backoffice.emp.domain.EmploymentRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
public class EmploymentServiceImpl implements EmploymentService {

    private final EmploymentRepository repository;

    public EmploymentServiceImpl(final EmploymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employment> all() {
        return repository.findAll();
    }

    @Override
    public Employment get(final Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Employment add(final Employment employment) {
        return repository.save(employment);
    }

    @Override
    public void remove(final Long id) {
        repository.deleteById(id);
    }

}
