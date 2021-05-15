package ru.mephi.reqsystem.repository.requirements;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.reqsystem.domain.requirements.RequirementVerificationType;

public interface RequirementVerificationTypeRepository extends JpaRepository<RequirementVerificationType, Long> {
    RequirementVerificationType findByName(String name);
}
