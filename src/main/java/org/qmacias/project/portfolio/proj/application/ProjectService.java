package org.qmacias.project.portfolio.proj.application;

import org.qmacias.project.portfolio.img.domain.Image;
import org.qmacias.project.portfolio.proj.domain.Project;
import org.qmacias.project.backoffice.skill.domain.SkillItem;
import org.qmacias.project.shared.application.GenericService;

public interface ProjectService extends GenericService<Project> {

    Project addSkillItem(final Long id, final SkillItem skillItem);

    Project removeSkillItem(final Long id, final SkillItem skillItem);

    Project assignImage(final Long id, final Image image);

}
