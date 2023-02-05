package org.qmacias.project.portfolio.job.application;

import org.qmacias.project.portfolio.job.domain.Job;
import org.qmacias.project.backoffice.skill.domain.SkillItem;
import org.qmacias.project.portfolio.job.domain.JobRepository;

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
    public Job addSkillItem(final Long id, final SkillItem skillItem) {
        final Job project = this.get(id);
        return repository.save(project.addSkillItem(skillItem));
    }

    @Override
    public Job removeSkillItem(final Long id, final SkillItem skillItem) {
        final Job project = this.get(id);
        return repository.save(project.removeSkillItem(skillItem));
    }

}
