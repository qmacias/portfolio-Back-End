package org.qmacias.project.portfolio.edu.application;

import org.qmacias.project.backoffice.mod.domain.Modality;
import org.qmacias.project.portfolio.cer.domain.Certification;
import org.qmacias.project.portfolio.img.domain.Image;
import org.qmacias.project.backoffice.cat.domain.Category;
import org.qmacias.project.portfolio.edu.domain.Education;
import org.qmacias.project.shared.application.GenericService;

public interface EducationService extends GenericService<Education, Long> {

    Education assignImage(final Long id, final Image image);

    Education assignCategory(final Long id, final Category category);

    Education assignModality(final Long id, final Modality modality);

    Education assignCertification(final Long id, final Certification certification);

}
