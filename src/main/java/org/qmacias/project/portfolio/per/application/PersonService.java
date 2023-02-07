package org.qmacias.project.portfolio.per.application;

import org.qmacias.project.portfolio.job.domain.Job;
import org.qmacias.project.portfolio.per.domain.Person;
import org.qmacias.project.shared.application.GenericService;

public interface PersonService extends GenericService<Person, Long> {

    Person addJobItem(final Long id, final Job job);

    Person removeJobItem(final Long id, final Job job);

}
