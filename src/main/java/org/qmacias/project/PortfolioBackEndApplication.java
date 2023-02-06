package org.qmacias.project;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.qmacias.project.backoffice.cat.domain.Category;
import org.qmacias.project.backoffice.cat.domain.CategoryRepository;
import org.qmacias.project.backoffice.emp.domain.Employment;
import org.qmacias.project.backoffice.emp.domain.EmploymentRepository;
import org.qmacias.project.backoffice.mod.domain.Modality;
import org.qmacias.project.backoffice.mod.domain.ModalityRepository;
import org.qmacias.project.backoffice.skill.domain.Skill;
import org.qmacias.project.backoffice.skill.domain.SkillRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class PortfolioBackEndApplication implements CommandLineRunner {

	private final SkillRepository skillRepository;

	private final CategoryRepository categoryRepository;

	private final ModalityRepository modalityRepository;

	private final EmploymentRepository employmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(PortfolioBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Skill> skills = Lists.newLinkedList();

		skills.add(new Skill("MySQL"));
		skills.add(new Skill("MongoDB"));
		skills.add(new Skill("PostgreSQL"));

		skillRepository.saveAll(skills);

		List<Category> categories = Lists.newLinkedList();

		categories.add(new Category("Curso"));
		categories.add(new Category("Pasantía"));
		categories.add(new Category("Congreso"));
		categories.add(new Category("Seminario"));

		categoryRepository.saveAll(categories);

		List<Modality> modalities = Lists.newLinkedList();

		modalities.add(new Modality("Presencial"));
		modalities.add(new Modality("A distancia"));

		modalityRepository.saveAll(modalities);

		List<Employment> employments = Lists.newLinkedList();

		employments.add(new Employment("Jornada parcial"));
		employments.add(new Employment("Jornada completa"));
		employments.add(new Employment("Contrato temporal"));

		employmentRepository.saveAll(employments);
	}

}
