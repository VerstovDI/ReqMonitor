package ru.mephi.reqsystem.repository.requirements;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.reqsystem.domain.requirements.Requirement;

public interface RequirementRepository extends JpaRepository<Requirement, Long> {
    Requirement findByTitle(String title);
}
