package org.qmacias.project.portfolio.proj.application;

import org.qmacias.project.portfolio.img.domain.Image;
import org.qmacias.project.portfolio.proj.domain.Project;
import org.qmacias.project.backoffice.skill.domain.Skill;
import org.qmacias.project.shared.application.GenericService;

public interface ProjectService extends GenericService<Project> {

    Project addSkillItem(final Long id, final Skill skill);

    Project removeSkillItem(final Long id, final Skill skill);

    Project assignImage(final Long id, final Image image);

}
