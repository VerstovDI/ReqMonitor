package ru.mephi.reqsystem.repository.requirements;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.reqsystem.domain.requirements.RequirementPriority;

public interface RequirementPriorityRepository extends JpaRepository<RequirementPriority, Long> {
    RequirementPriority findByName(String name);
}
