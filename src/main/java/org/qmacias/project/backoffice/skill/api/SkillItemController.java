package org.qmacias.project.backoffice.skill.api;

import org.qmacias.project.backoffice.skill.application.SkillItemService;
import org.qmacias.project.backoffice.skill.domain.SkillItem;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
final class SkillItemController {

    private final SkillItemService service;

    SkillItemController(final SkillItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<SkillItem> allSkillItems() {
        return service.all();
    }

    @GetMapping("/{id}")
    public SkillItem getSkillItem(@PathVariable final Long id) {
        return service.get(id);
    }

    @PostMapping
    public SkillItem addSkillItem(@RequestBody final SkillItem skillItem) {
        return service.add(skillItem);
    }

    @DeleteMapping("/{id}")
    public void removeSkillItem(@PathVariable final Long id) {
        service.remove(id);
    }

}
