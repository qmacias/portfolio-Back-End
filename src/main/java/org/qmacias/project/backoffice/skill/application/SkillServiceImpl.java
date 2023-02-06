package org.qmacias.project.backoffice.skill.application;

import org.qmacias.project.backoffice.skill.domain.Skill;
import org.qmacias.project.backoffice.skill.domain.SkillRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {

    private final SkillRepository repository;

    public SkillServiceImpl(final SkillRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Skill> all() {
        return repository.findAll();
    }

    @Override
    public Skill get(final Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Skill add(final Skill skill) {
        return repository.save(skill);
    }

    @Override
    public void remove(final Long id) {
        repository.deleteById(id);
    }

}