package ru.mephi.reqsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mephi.reqsystem.domain.requirements.RequirementStatus;
import ru.mephi.reqsystem.repository.requirements.RequirementStatusRepository;

@Service
public class RequirementStatusService {
    private final RequirementStatusRepository requirementStatusRepository;

    @Autowired
    public RequirementStatusService(RequirementStatusRepository requirementStatusRepository) {
        this.requirementStatusRepository = requirementStatusRepository;
    }


    public RequirementStatus getNewRequirementStatus() {
        RequirementStatus requirementStatusFromDb = requirementStatusRepository.findByName("New");
        if(requirementStatusFromDb!=null){
            return requirementStatusFromDb;
        }
        return requirementStatusRepository.save(new RequirementStatus("New"));
    }

}
