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
//@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {
    private long id;
    private LocalDateTime orderDate;
    private long customerId;
    private String customerName;
    private long employeeId;
    private String employeeFullname;
}
