package net.proselyte.coursework.repository;

import net.proselyte.coursework.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}