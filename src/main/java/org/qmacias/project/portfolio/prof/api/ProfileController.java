package org.qmacias.project.portfolio.prof.api;

import lombok.RequiredArgsConstructor;

import org.qmacias.project.portfolio.soc.domain.Social;
import org.qmacias.project.portfolio.prof.domain.Profile;
import org.qmacias.project.portfolio.soc.application.SocialService;
import org.qmacias.project.portfolio.prof.application.ProfileService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile")
final class ProfileController {

    private final ProfileService service;

    private final SocialService socialService;

    @GetMapping
    public List<Profile> allProfiles() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Profile getProfile(@PathVariable final Long id) {
        return service.get(id);
    }

    @PostMapping
    public Profile addProfile(@RequestBody final Profile profile) {
        return service.add(profile);
    }

    @DeleteMapping("/{id}")
    public void removeProfile(@PathVariable final Long id) {
        service.remove(id);
    }

    @PutMapping("/{id}/social/{socialId}")
    public Profile addSocialItem(@PathVariable final Long id, @PathVariable final Long socialId) {
        final Social social = socialService.get(socialId);
        return service.addSocialItem(id, social);
    }

    @PutMapping("/{id}/remove_social/{socialId}")
    public Profile removeSocialItem(@PathVariable final Long id, @PathVariable final Long socialId) {
        final Social social = socialService.get(socialId);
        return service.removeSocialItem(id, social);
    }

}
