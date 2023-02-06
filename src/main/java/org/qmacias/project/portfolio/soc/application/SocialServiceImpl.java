package org.qmacias.project.portfolio.soc.application;

import org.qmacias.project.portfolio.soc.domain.Social;
import org.qmacias.project.portfolio.soc.domain.SocialRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialServiceImpl implements SocialService {

    private final SocialRepository repository;

    public SocialServiceImpl(final SocialRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Social> all() {
        return repository.findAll();
    }

    @Override
    public Social get(final Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Social add(final Social social) {
        return repository.save(social);
    }

    @Override
    public void remove(final Long id) {
        repository.deleteById(id);
    }

}
