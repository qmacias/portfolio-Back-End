package org.qmacias.project.portfolio.prof.application;

import org.qmacias.project.portfolio.soc.domain.Social;
import org.qmacias.project.portfolio.adr.domain.Address;
import org.qmacias.project.portfolio.prof.domain.Profile;
import org.qmacias.project.portfolio.prof.domain.ProfileRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;

    public ProfileServiceImpl(final ProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Profile> all() {
        return repository.findAll();
    }

    @Override
    public Profile get(final Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Profile add(final Profile profile) {
        return repository.save(profile);
    }

    @Override
    public void remove(final Long id) {
        repository.deleteById(id);
    }

    @Override
    public Profile addSocialItem(final Long id, final Social social) {
        final Profile profile = this.get(id);
        return this.add(profile.addSocialItem(social));
    }

    @Override
    public Profile removeSocialItem(final Long id, final Social social) {
        final Profile profile = this.get(id);
        return this.add(profile.removeSocialItem(social));
    }

    @Override
    public Profile addAddressItem(final Long id, final Address address) {
        final Profile profile = this.get(id);
        return this.add(profile.addAddressItem(address));
    }

    @Override
    public Profile removeAddressItem(final Long id, final Address address) {
        final Profile profile = this.get(id);
        return this.add(profile.removeAddressItem(address));
    }

}
