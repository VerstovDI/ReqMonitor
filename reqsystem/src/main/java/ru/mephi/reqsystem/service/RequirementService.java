package ru.mephi.reqsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mephi.reqsystem.domain.requirements.Project;
import ru.mephi.reqsystem.domain.requirements.Release;
import ru.mephi.reqsystem.domain.requirements.Requirement;
import ru.mephi.reqsystem.domain.requirements.Specification;
import ru.mephi.reqsystem.repository.requirements.RequirementRepository;

import java.util.List;

@Service
public class RequirementService {
    private final RequirementRepository requirementRepository;

    @Autowired
    public RequirementService(RequirementRepository requirementRepository) {
        this.requirementRepository = requirementRepository;
    }

    public boolean addRequirement(Requirement requirement) {
        Requirement requirementFromDb = requirementRepository.findByTitleAndDescriptionAndRelease(
                requirement.getTitle(),requirement.getDescription(), requirement.getRelease());
        if (requirementFromDb != null) {
            return false;
        }
        requirementRepository.save(requirement);
        return true;
    }

    public List<Requirement> showReqForRelease(Release release) {
        return requirementRepository.findByRelease(release);
    }
}
