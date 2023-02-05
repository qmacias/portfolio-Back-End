package org.qmacias.project.backoffice.skill.api;

import org.qmacias.project.backoffice.skill.domain.Skill;
import org.qmacias.project.backoffice.skill.application.SkillService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
final class SkillController {

    private final SkillService service;

    SkillController(final SkillService service) {
        this.service = service;
    }

    @GetMapping
    public List<Skill> allSkills() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Skill getSkill(@PathVariable final Long id) {
        return service.get(id);
    }

    @PostMapping
    public Skill addSkill(@RequestBody final Skill skill) {
        return service.add(skill);
    }

    @DeleteMapping("/{id}")
    public void removeSkill(@PathVariable final Long id) {
        service.remove(id);
    }

}
