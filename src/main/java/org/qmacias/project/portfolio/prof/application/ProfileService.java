package org.qmacias.project.portfolio.prof.application;

import org.qmacias.project.portfolio.soc.domain.Social;
import org.qmacias.project.portfolio.prof.domain.Profile;
import org.qmacias.project.shared.application.GenericService;

public interface ProfileService extends GenericService<Profile> {

    Profile addSocialItem(final Long id, final Social social);

    Profile removeSocialItem(final Long id, final Social social);

}
