package org.qmacias.project.portfolio.job.api;

import org.qmacias.project.portfolio.job.domain.Job;
import org.qmacias.project.backoffice.skill.domain.Skill;
import org.qmacias.project.portfolio.job.application.JobService;
import org.qmacias.project.backoffice.skill.application.SkillService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
final class JobController {

    private final JobService service;

    private final SkillService skillService;

    JobController(final JobService service, final SkillService skillService) {
        this.service = service;
        this.skillService = skillService;
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

    @PutMapping("/{id}/skill/{skillId}")
    public Job addSkillItem(@PathVariable final Long id, @PathVariable final Long skillId) {
        final Skill skill = skillService.get(skillId);
        return service.addSkillItem(id, skill);
    }

    @PutMapping("/{id}/remove_skill/{skillId}")
    public Job removeSkillItem(@PathVariable final Long id, @PathVariable final Long skillId) {
        final Skill skill = skillService.get(skillId);
        return service.removeSkillItem(id, skill);
    }

}
