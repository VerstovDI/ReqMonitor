package ru.mephi.reqsystem.repository.requirements;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.reqsystem.domain.requirements.RequirementLinkType;

public interface RequirementLinkTypeRepository extends JpaRepository<RequirementLinkType, Long> {
    RequirementLinkType findByName(String name);
}
