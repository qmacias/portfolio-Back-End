package org.qmacias.project.portfolio.soc.api;

import org.qmacias.project.portfolio.soc.domain.Social;
import org.qmacias.project.portfolio.soc.application.SocialService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/social")
final class SocialController {

    private final SocialService service;

    SocialController(final SocialService service) {
        this.service = service;
    }

    @GetMapping
    public List<Social> allSocial() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Social getSocial(@PathVariable final Long id) {
        return service.get(id);
    }

    @PostMapping
    public Social addSocial(@RequestBody final Social social) {
        return service.add(social);
    }

    @DeleteMapping("/{id}")
    public void removeSocial(@PathVariable final Long id) {
        service.remove(id);
    }

}
