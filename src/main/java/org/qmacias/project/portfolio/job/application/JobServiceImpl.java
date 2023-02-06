package org.qmacias.project.portfolio.job.application;

import org.qmacias.project.backoffice.emp.domain.Employment;
import org.qmacias.project.portfolio.img.domain.Image;
import org.qmacias.project.portfolio.job.domain.Job;
import org.qmacias.project.backoffice.skill.domain.Skill;
import org.qmacias.project.portfolio.job.domain.JobRepository;

import org.qmacias.project.portfolio.proj.domain.Project;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
public class JobServiceImpl implements JobService {

    private final JobRepository repository;

    public JobServiceImpl(final JobRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Job> all() {
        return repository.findAll();
    }

    @Override
    public Job get(final Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Job add(final Job job) {
        return repository.save(job);
    }

    @Override
    public void remove(final Long id) {
        repository.deleteById(id);
    }

    @Override
    public Job addSkillItem(final Long id, final Skill skill) {
        final Job project = this.get(id);
        return this.add(project.addSkillItem(skill));
    }

    @Override
    public Job removeSkillItem(final Long id, final Skill skill) {
        final Job project = this.get(id);
        return this.add(project.removeSkillItem(skill));
    }

    @Override
    public Job assignEmployment(final Long id, final Employment employment) {
        final Job job = this.get(id);
        job.setEmployment(employment);
        return this.add(job);
    }

}
