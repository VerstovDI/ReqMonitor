package ru.mephi.reqsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mephi.reqsystem.domain.requirements.Requirement;
import ru.mephi.reqsystem.domain.requirements.RequirementVerification;
import ru.mephi.reqsystem.domain.requirements.RequirementVerificationType;
import ru.mephi.reqsystem.repository.requirements.RequirementVerificationRepository;
import ru.mephi.reqsystem.repository.requirements.RequirementVerificationTypeRepository;

import java.util.Date;

@Service
public class RequirementVerificationService {
    private final RequirementVerificationRepository requirementVerificationRepository;
    private final RequirementVerificationTypeRepository requirementVerificationTypeRepository;

    @Autowired
    public RequirementVerificationService(RequirementVerificationRepository requirementVerificationRepository, RequirementVerificationTypeRepository requirementVerificationTypeRepository) {
        this.requirementVerificationRepository = requirementVerificationRepository;
        this.requirementVerificationTypeRepository = requirementVerificationTypeRepository;
    }


    public boolean addNonVerifiedVerificationToRequirements(Requirement requirement) {
        RequirementVerificationType nonVerified = requirementVerificationTypeRepository.findByName("Non verified");
        if(nonVerified==null){
            nonVerified=new RequirementVerificationType("Non verified");
            nonVerified=requirementVerificationTypeRepository.save(nonVerified);
        }
        if(!requirementVerificationRepository.findAllByRequirementVerificationTypeAndRequirement(nonVerified,requirement).isEmpty()){
            return false;
        }
        RequirementVerification requirementVerification = new RequirementVerification(new Date(), nonVerified, requirement);
        requirementVerificationRepository.save(requirementVerification);
        return true;
    }

}
