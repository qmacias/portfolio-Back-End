package org.qmacias.project.backoffice.skill.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface SkillItemRepository extends JpaRepository<SkillItem, Long> {
}