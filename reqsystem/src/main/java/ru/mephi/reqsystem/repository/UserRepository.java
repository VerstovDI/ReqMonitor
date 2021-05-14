package ru.mephi.reqsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.reqsystem.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
