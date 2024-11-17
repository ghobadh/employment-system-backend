package ca.gforcesoftware.employmentsystembackend.controller;

import ca.gforcesoftware.employmentsystembackend.dto.EmployeeDto;
import ca.gforcesoftware.employmentsystembackend.entity.Employee;
import ca.gforcesoftware.employmentsystembackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gavinhashemi on 2024-11-16
 */
@AllArgsConstructor
@RestController
@RequestMapping("/restful/employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    @PostMapping("/new")
    public ResponseEntity<EmployeeDto> newEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto createdEmployee =  employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,
                                                      @RequestBody EmployeeDto employeeDto) {
        EmployeeDto updatedEmployee = employeeService.updateEmployee(id, employeeDto);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee with id: " + id +" deleted", HttpStatus.OK);
    }
}
