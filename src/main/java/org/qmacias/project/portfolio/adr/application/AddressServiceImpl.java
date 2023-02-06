package org.qmacias.project.portfolio.adr.application;

import org.qmacias.project.portfolio.adr.domain.Address;
import org.qmacias.project.portfolio.adr.domain.AddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;

    public AddressServiceImpl(final AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Address> all() {
        return repository.findAll();
    }

    @Override
    public Address get(final Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Address add(final Address address) {
        return repository.save(address);
    }

    @Override
    public void remove(final Long id) {
        repository.deleteById(id);
    }

}
