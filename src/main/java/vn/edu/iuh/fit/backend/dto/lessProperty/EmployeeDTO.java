package vn.edu.iuh.fit.backend.dto.lessProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    private long id;
    private String address;
    private LocalDateTime dob;
    private String email;
    private String fullname;
    private String phone;
    private String status;
}
