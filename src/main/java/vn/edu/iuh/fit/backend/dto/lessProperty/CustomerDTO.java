package vn.edu.iuh.fit.backend.dto.lessProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {
    private long id;
    private String address;
    private String email;
    private String name;
    private String phone;
}
