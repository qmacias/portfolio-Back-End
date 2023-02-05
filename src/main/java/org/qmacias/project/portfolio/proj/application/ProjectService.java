package org.qmacias.project.portfolio.proj.application;

import org.qmacias.project.portfolio.img.domain.Image;
import org.qmacias.project.portfolio.skill.domain.SkillItem;
import org.qmacias.project.shared.application.Service;
import org.qmacias.project.portfolio.proj.domain.Project;

public interface ProjectService extends Service<Project> {

    Project addSkillItem(final Long id, final SkillItem skillItem);

    Project removeSkillItem(final Long id, final SkillItem skillItem);

    Project assignImage(final Long id, final Image image);

}
