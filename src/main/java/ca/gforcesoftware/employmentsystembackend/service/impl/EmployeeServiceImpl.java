package ca.gforcesoftware.employmentsystembackend.service.impl;

import ca.gforcesoftware.employmentsystembackend.dto.EmployeeDto;
import ca.gforcesoftware.employmentsystembackend.entity.Employee;
import ca.gforcesoftware.employmentsystembackend.exception.ResourceNotFoundException;
import ca.gforcesoftware.employmentsystembackend.mapper.EmployeeMapper;
import ca.gforcesoftware.employmentsystembackend.repository.EmployeeRepository;
import ca.gforcesoftware.employmentsystembackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gavinhashemi on 2024-11-16
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.toEmployee(employeeDto);
       // I save the employee, and the result of saved employee will be converted to employee DTO and it will be returned
        return EmployeeMapper.toEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream().map(EmployeeMapper::toEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee with id " + id + " not found")
        );
        return EmployeeMapper.toEmployeeDto(employee);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee with id " + id + " not found")
        );
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        return EmployeeMapper.toEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee with id " + id + " not found")
        );
        employeeRepository.delete(employee);
    }
}
