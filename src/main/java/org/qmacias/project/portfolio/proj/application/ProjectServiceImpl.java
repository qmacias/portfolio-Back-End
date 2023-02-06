package org.qmacias.project.portfolio.proj.application;

import org.qmacias.project.portfolio.img.domain.Image;
import org.qmacias.project.portfolio.proj.domain.Project;
import org.qmacias.project.backoffice.skill.domain.Skill;
import org.qmacias.project.portfolio.proj.domain.ProjectRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository repository;

    public ProjectServiceImpl(final ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Project> all() {
        return repository.findAll();
    }

    @Override
    public Project get(final Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Project add(final Project project) {
        return repository.save(project);
    }

    @Override
    public void remove(final Long id) {
        repository.deleteById(id);
    }

    @Override
    public Project addSkillItem(final Long id, final Skill skill) {
        final Project project = this.get(id);
        return this.add(project.addSkillItem(skill));
    }

    @Override
    public Project removeSkillItem(final Long id, final Skill skill) {
        final Project project = this.get(id);
        return this.add(project.removeSkillItem(skill));
    }

    @Override
    public Project assignImage(final Long id, final Image image) {
        final Project project = this.get(id);
        project.setImage(image);
        return this.add(project);
    }

}