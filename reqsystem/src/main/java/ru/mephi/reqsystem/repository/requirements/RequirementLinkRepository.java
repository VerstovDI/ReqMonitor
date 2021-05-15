package ru.mephi.reqsystem.repository.requirements;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.reqsystem.domain.requirements.RequirementLink;

public interface RequirementLinkRepository extends JpaRepository<RequirementLink, Long> {
    RequirementLink findByDescription(String description);
}
