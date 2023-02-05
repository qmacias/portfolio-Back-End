package org.qmacias.project;

import com.google.common.collect.Lists;
import org.qmacias.project.backoffice.emp.domain.Employment;
import org.qmacias.project.backoffice.emp.domain.EmploymentRepository;
import org.qmacias.project.backoffice.skill.domain.Skill;
import org.qmacias.project.backoffice.skill.domain.SkillRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PortfolioBackEndApplication implements CommandLineRunner {

	private final SkillRepository skillRepository;

	private final EmploymentRepository employmentRepository;

	public PortfolioBackEndApplication(final SkillRepository skillRepository, final EmploymentRepository employmentRepository) {
		this.skillRepository = skillRepository;
		this.employmentRepository = employmentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(PortfolioBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Employment> employments = Lists.newLinkedList();

		employments.add(new Employment("Full-time"));
		employments.add(new Employment("Part-time"));
		employments.add(new Employment("Fixed-term"));

		employmentRepository.saveAll(employments);

		List<Skill> skills = Lists.newLinkedList();

		skills.add(new Skill("MySQL"));
		skills.add(new Skill("MongoDB"));
		skills.add(new Skill("PostgresSQL"));

		skillRepository.saveAll(skills);
	}

}
