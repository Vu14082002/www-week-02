package vn.edu.iuh.fit.backend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "customer")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NamedQueries({
        @NamedQuery(name = "customer.findAll", query = "select c from Customer  c"),
})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private long id;

    @Column(name = "address", length = 250, nullable = false)
    private String address;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "cust_name", length = 150, nullable = false)
    private String name;

    @Column(name = "phone", length = 15, nullable = false)
    private String phone;

    @OneToMany(mappedBy = "customer", cascade ={CascadeType.PERSIST,CascadeType.MERGE})
    private List<Order> orderList = new ArrayList<>();

    @PreRemove
    private void remove(){
        this.orderList.forEach(e-> e.setCustomer(null));
    }
}
