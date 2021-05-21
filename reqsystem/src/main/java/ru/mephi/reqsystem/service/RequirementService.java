package ru.mephi.reqsystem.service;

import org.springframework.stereotype.Service;
import ru.mephi.reqsystem.domain.requirements.Requirement;
import ru.mephi.reqsystem.repository.requirements.RequirementRepository;

@Service
public class RequirementService {
    private final RequirementRepository requirementRepository;


    public RequirementService(RequirementRepository requirementRepository) {
        this.requirementRepository = requirementRepository;
    }


    public boolean addRequirement(Requirement requirement) {
        Requirement requirementFromDb = requirementRepository.findByTitle(requirement.getTitle());
        if (requirementFromDb != null) {
            return false;
        }
        requirementRepository.save(requirement);
        return true;
    }

}
