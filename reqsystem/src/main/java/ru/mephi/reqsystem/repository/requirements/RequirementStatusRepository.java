package ru.mephi.reqsystem.repository.requirements;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.reqsystem.domain.requirements.RequirementStatus;

public interface RequirementStatusRepository extends JpaRepository<RequirementStatus, Long> {
    RequirementStatus findByName(String name);
}
