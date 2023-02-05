package org.qmacias.project.portfolio.job.api;

import org.qmacias.project.portfolio.job.domain.Job;
import org.qmacias.project.backoffice.skill.domain.SkillItem;
import org.qmacias.project.portfolio.job.application.JobService;
import org.qmacias.project.backoffice.skill.application.SkillItemService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
final class JobController {

    private final JobService service;

    private final SkillItemService skillItemService;

    JobController(final JobService service, final SkillItemService skillItemService) {
        this.service = service;
        this.skillItemService = skillItemService;
    }

    @GetMapping
    public List<Job> allJobs() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Job getJob(@PathVariable final Long id) {
        return service.get(id);
    }

    @PostMapping
    public Job addJob(@RequestBody final Job job) {
        return service.add(job);
    }

    @DeleteMapping("/{id}")
    public void removeJob(@PathVariable final Long id) {
        service.remove(id);
    }

    @PutMapping("/{id}/skill/{skillItemId}")
    public Job addSkillItem(@PathVariable final Long id, @PathVariable final Long skillItemId) {
        final SkillItem skillItem = skillItemService.get(skillItemId);
        return service.addSkillItem(id, skillItem);
    }

    @PutMapping("/{id}/remove_skill/{skillItemId}")
    public Job removeSkillItem(@PathVariable final Long id, @PathVariable final Long skillItemId) {
        final SkillItem skillItem = skillItemService.get(skillItemId);
        return service.removeSkillItem(id, skillItem);
    }

}
