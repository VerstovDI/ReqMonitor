package ru.mephi.reqsystem.repository.requirements;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.reqsystem.domain.requirements.Project;
import ru.mephi.reqsystem.domain.requirements.Specification;

public interface SpecificationRepository extends JpaRepository<Specification, Long> {

}
