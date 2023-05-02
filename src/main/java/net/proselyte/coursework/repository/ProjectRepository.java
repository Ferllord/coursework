package net.proselyte.coursework.repository;

import net.proselyte.coursework.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
