package org.qmacias.project.portfolio.proj.api;

import org.qmacias.project.portfolio.img.domain.Image;
import org.qmacias.project.portfolio.proj.domain.Project;
import org.qmacias.project.backoffice.skill.domain.Skill;
import org.qmacias.project.portfolio.img.application.ImageService;
import org.qmacias.project.portfolio.proj.application.ProjectService;
import org.qmacias.project.backoffice.skill.application.SkillService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
final class ProjectController {

    private final ProjectService service;

    private final ImageService imageService;

    private final SkillService skillService;

    ProjectController(final ProjectService service, final ImageService imageService, final SkillService skillService) {
        this.service = service;
        this.imageService = imageService;
        this.skillService = skillService;
    }

    @GetMapping
    public List<Project> allProjects() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Project getProject(@PathVariable final Long id) {
        return service.get(id);
    }

    @PostMapping
    public Project addProject(@RequestBody final Project project) {
        return service.add(project);
    }

    @DeleteMapping("/{id}")
    public void removeProject(@PathVariable final Long id) {
        service.remove(id);
    }

    @PutMapping("/{id}/skill/{skillId}")
    public Project addSkillItem(@PathVariable final Long id, @PathVariable final Long skillId) {
        final Skill skill = skillService.get(skillId);
        return service.addSkillItem(id, skill);
    }

    @PutMapping("/{id}/remove_skill/{skillId}")
    public Project removeSkillItem(@PathVariable final Long id, @PathVariable final Long skillId) {
        final Skill skill = skillService.get(skillId);
        return service.removeSkillItem(id, skill);
    }

    @PutMapping("/{id}/image_detail/{imageId}")
    public Project assignImageDetail(@PathVariable final Long id, @PathVariable final Long imageId) {
        final Image image = imageService.get(imageId);
        return service.assignImage(id, image);
    }

}