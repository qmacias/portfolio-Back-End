package org.qmacias.project.portfolio.cer.application;

import org.qmacias.project.portfolio.img.domain.Image;
import org.qmacias.project.shared.application.GenericService;
import org.qmacias.project.portfolio.cer.domain.Certification;

public interface CertificationService extends GenericService<Certification, String> {

    Certification assignImage(final String id, final Image image);

}
