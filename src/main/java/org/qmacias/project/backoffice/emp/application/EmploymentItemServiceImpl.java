package org.qmacias.project.backoffice.emp.application;

import org.qmacias.project.backoffice.emp.domain.EmploymentItem;
import org.qmacias.project.backoffice.emp.domain.EmploymentItemRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
public class EmploymentItemServiceImpl implements EmploymentItemService {

    private final EmploymentItemRepository repository;

    public EmploymentItemServiceImpl(final EmploymentItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EmploymentItem> all() {
        return repository.findAll();
    }

    @Override
    public EmploymentItem get(final Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public EmploymentItem add(final EmploymentItem employmentItem) {
        return repository.save(employmentItem);
    }

    @Override
    public void remove(final Long id) {
        repository.deleteById(id);
    }

}
