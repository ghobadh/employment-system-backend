package ca.gforcesoftware.employmentsystembackend.mapper;

import ca.gforcesoftware.employmentsystembackend.dto.EmployeeDto;
import ca.gforcesoftware.employmentsystembackend.entity.Employee;
import org.modelmapper.ModelMapper;

/**
 * @author gavinhashemi on 2024-11-15
 */
public class EmployeeMapper {
    private static ModelMapper  modelMapper = new ModelMapper();

    public static EmployeeDto toEmployeeDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDto.class);
    }

    public static Employee toEmployee(EmployeeDto employeeDto) {
        return modelMapper.map(employeeDto, Employee.class);
    }
}
