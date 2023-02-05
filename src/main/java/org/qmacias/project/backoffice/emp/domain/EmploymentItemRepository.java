package org.qmacias.project.backoffice.emp.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentItemRepository extends JpaRepository<EmploymentItem, Long> {
}
