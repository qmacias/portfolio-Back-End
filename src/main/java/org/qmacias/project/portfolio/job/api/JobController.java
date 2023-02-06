package org.qmacias.project.portfolio.job.api;

import org.qmacias.project.backoffice.emp.application.EmploymentService;
import org.qmacias.project.backoffice.emp.domain.Employment;
import org.qmacias.project.portfolio.img.domain.Image;
import org.qmacias.project.portfolio.job.domain.Job;
import org.qmacias.project.backoffice.skill.domain.Skill;
import org.qmacias.project.portfolio.job.application.JobService;
import org.qmacias.project.backoffice.skill.application.SkillService;

import org.qmacias.project.portfolio.proj.domain.Project;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
final class JobController {

    private final JobService service;

    private final SkillService skillService;

    private final EmploymentService employmentService;

    JobController(final JobService service, final SkillService skillService, final EmploymentService employmentService) {
        this.service = service;
        this.skillService = skillService;
        this.employmentService = employmentService;
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

    @PutMapping("/{id}/employment_detail/{employmentId}")
    public Job assignJobDetail(@PathVariable final Long id, @PathVariable final Long employmentId) {
        final Employment employment = employmentService.get(employmentId);
        return service.assignEmployment(id, employment);
    }

}
