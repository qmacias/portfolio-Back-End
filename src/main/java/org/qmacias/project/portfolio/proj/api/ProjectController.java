package org.qmacias.project.portfolio.proj.api;

import org.qmacias.project.portfolio.img.application.ImageService;
import org.qmacias.project.portfolio.img.domain.Image;
import org.qmacias.project.portfolio.proj.domain.Project;
import org.qmacias.project.portfolio.skill.domain.SkillItem;
import org.qmacias.project.portfolio.proj.application.ProjectService;
import org.qmacias.project.portfolio.skill.application.SkillItemService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
final class ProjectController {

    private final ProjectService service;

    private final ImageService imageService;

    private final SkillItemService skillItemService;

    ProjectController(final ProjectService service, final ImageService imageService, final SkillItemService skillItemService) {
        this.service = service;
        this.imageService = imageService;
        this.skillItemService = skillItemService;
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

    @PutMapping("/{id}/skill/{skillItemId}")
    public Project addSkillItem(@PathVariable final Long id, @PathVariable final Long skillItemId) {
        final SkillItem skillItem = skillItemService.get(skillItemId);
        return service.addSkillItem(id, skillItem);
    }

    @PutMapping("/{id}/remove_skill/{skillItemId}")
    public Project removeSkillItem(@PathVariable final Long id, @PathVariable final Long skillItemId) {
        final SkillItem skillItem = skillItemService.get(skillItemId);
        return service.removeSkillItem(id, skillItem);
    }

    @PutMapping("/{id}/detail/{imageId}")
    public Project addDetail(@PathVariable final Long id, @PathVariable final Long imageId) {
        final Image image = imageService.get(imageId);
        return service.assignImage(id, image);
    }
}