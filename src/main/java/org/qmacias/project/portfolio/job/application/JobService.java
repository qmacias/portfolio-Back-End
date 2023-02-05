package org.qmacias.project.portfolio.job.application;

import org.qmacias.project.portfolio.job.domain.Job;
import org.qmacias.project.portfolio.skill.domain.SkillItem;
import org.qmacias.project.shared.application.GenericService;

public interface JobService extends GenericService<Job> {

    Job addSkillItem(final Long id, final SkillItem skillItem);

    Job removeSkillItem(final Long id, final SkillItem skillItem);

}
