package org.qmacias.project.portfolio.skill.application;

import org.qmacias.project.portfolio.skill.domain.SkillItem;
import org.qmacias.project.portfolio.skill.domain.SkillItemRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
public class SkillItemServiceImpl implements SkillItemService {

    private final SkillItemRepository repository;

    public SkillItemServiceImpl(final SkillItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SkillItem> all() {
        return repository.findAll();
    }

    @Override
    public SkillItem get(final Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public SkillItem add(final SkillItem skillItem) {
        return repository.save(skillItem);
    }

    @Override
    public void remove(final Long id) {
        repository.deleteById(id);
    }

}