package org.qmacias.project.portfolio.per.application;

import org.qmacias.project.portfolio.per.domain.Person;

import org.qmacias.project.portfolio.per.domain.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    public PersonServiceImpl(final PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> all() {
        return repository.findAll();
    }

    @Override
    public Person get(final Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Person add(final Person person) {
        return repository.save(person);
    }

    @Override
    public void remove(final Long id) {
        repository.deleteById(id);
    }

}
