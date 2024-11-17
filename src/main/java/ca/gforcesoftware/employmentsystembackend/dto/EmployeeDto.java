package ca.gforcesoftware.employmentsystembackend.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gavinhashemi on 2024-11-15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
