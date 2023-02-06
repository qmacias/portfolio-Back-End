package org.qmacias.project.portfolio.job.application;

import org.qmacias.project.backoffice.emp.domain.Employment;
import org.qmacias.project.portfolio.job.domain.Job;
import org.qmacias.project.backoffice.skill.domain.Skill;
import org.qmacias.project.shared.application.GenericService;

public interface JobService extends GenericService<Job> {

    Job addSkillItem(final Long id, final Skill skill);

    Job removeSkillItem(final Long id, final Skill skill);

    Job assignEmployment(final Long id, final Employment employment);

}
