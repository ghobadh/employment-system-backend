package ca.gforcesoftware.employmentsystembackend.service;

import ca.gforcesoftware.employmentsystembackend.dto.EmployeeDto;

import java.util.List;

/**
 * @author gavinhashemi on 2024-11-16
 */
public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto eployeeDto);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(Long id);
    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);
    void deleteEmployee(Long id);

}
