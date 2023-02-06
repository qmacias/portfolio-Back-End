package org.qmacias.project.portfolio.prof.application;

import org.qmacias.project.portfolio.phn.domain.Phone;
import org.qmacias.project.portfolio.soc.domain.Social;
import org.qmacias.project.portfolio.adr.domain.Address;
import org.qmacias.project.portfolio.prof.domain.Profile;
import org.qmacias.project.shared.application.GenericService;

public interface ProfileService extends GenericService<Profile, Long> {

    Profile addSocialItem(final Long id, final Social social);

    Profile removeSocialItem(final Long id, final Social social);

    Profile addAddressItem(final Long id, final Address address);

    Profile removeAddressItem(final Long id, final Address address);

    Profile addPhoneItem(final Long id, final Phone phone);

    Profile removePhoneItem(final Long id, final Phone phone);

}
