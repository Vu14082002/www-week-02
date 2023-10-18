package vn.edu.iuh.fit.backend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.backend.enums.EmployeeStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@NamedQueries(
        {
                @NamedQuery(name = "employee.findById", query = "SELECT e from Employee e WHERE (e.id = :id )"),
                @NamedQuery(name = "employee.findByIdJoinFetcj",
                        query = "SELECT e from Employee e join  fetch e.lstOrder where (e.id = :id )"),
                @NamedQuery(name = "employee.findAll", query = "select  e from Employee  e where  e.status= 1 "),

        }
)
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long id;

    @Column(name = "address", length = 250, nullable = false)
    private String address;

    @Column(nullable = false, name = "dob")
    private LocalDateTime dob;

    @Column(name = "email", length = 150, unique = true)
    private String email;

    @Column(name = "full_name", length = 150, nullable = false)
    private String fullname;

    @Column(name = "phone", length = 15, nullable = false)
    private String phone;

    @Column(name = "status", nullable = false)
    private EmployeeStatus status;

    @OneToMany(mappedBy = "employee", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Order> lstOrder;

    public Employee(String address, LocalDateTime dob, String email, String fullname, String phone, EmployeeStatus status) {
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.fullname = fullname;
        this.phone = phone;
        this.status = status;
    }

    public void addOrder(Order order) {
        if (this.lstOrder == null) {
            this.lstOrder = new ArrayList<>();
        }
        this.lstOrder.add(order);
        order.setEmployee(this);
    }

    @PreRemove
    public void removeOrder() {
        this.lstOrder.forEach(e -> e.setEmployee(null));
    }

}
