package ru.mephi.reqsystem.repository.requirements;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.reqsystem.domain.requirements.Requirement;
import ru.mephi.reqsystem.domain.requirements.RequirementVerification;
import ru.mephi.reqsystem.domain.requirements.RequirementVerificationType;

import java.util.Date;
import java.util.List;

public interface RequirementVerificationRepository extends JpaRepository<RequirementVerification, Long> {
    List<RequirementVerification> findAllByRequirementVerificationType(String type);

    List<RequirementVerification> findAllByDate(Date date);

    List<RequirementVerification> findAllByRequirementVerificationTypeAndRequirement
            (RequirementVerificationType requirementVerificationType, Requirement requirement);
}
