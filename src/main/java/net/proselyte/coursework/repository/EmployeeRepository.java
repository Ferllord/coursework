package net.proselyte.coursework.repository;

import net.proselyte.coursework.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
