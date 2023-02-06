package org.qmacias.project.portfolio.prof.application;

import org.qmacias.project.portfolio.prof.domain.Profile;
import org.qmacias.project.portfolio.prof.domain.ProfileRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;

    public ProfileServiceImpl(final ProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Profile> all() {
        return repository.findAll();
    }

    @Override
    public Profile get(final Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Profile add(final Profile profile) {
        return repository.save(profile);
    }

    @Override
    public void remove(final Long id) {
        repository.deleteById(id);
    }

}
