package ru.mephi.reqsystem.repository.requirements;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.reqsystem.domain.requirements.RequirementObjectType;

public interface RequirementObjectTypeRepository extends JpaRepository<RequirementObjectType, Long> {
    RequirementObjectType findByName(String name);
}
