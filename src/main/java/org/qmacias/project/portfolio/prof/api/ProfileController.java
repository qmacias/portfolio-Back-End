package org.qmacias.project.portfolio.prof.api;

import org.qmacias.project.portfolio.prof.domain.Profile;
import org.qmacias.project.portfolio.prof.application.ProfileService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
final class ProfileController {

    private final ProfileService service;

    ProfileController(final ProfileService service) {
        this.service = service;
    }

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

}
