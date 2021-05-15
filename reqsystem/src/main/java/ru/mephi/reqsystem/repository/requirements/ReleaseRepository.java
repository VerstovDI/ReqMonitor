package ru.mephi.reqsystem.repository.requirements;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.reqsystem.domain.administration.User;
import ru.mephi.reqsystem.domain.requirements.Release;

public interface ReleaseRepository extends JpaRepository<Release, Long> {
    User findByDescription(String description);
}
