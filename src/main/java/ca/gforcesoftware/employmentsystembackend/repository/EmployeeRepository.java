package ca.gforcesoftware.employmentsystembackend.repository;

import ca.gforcesoftware.employmentsystembackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gavinhashemi on 2024-11-15
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
