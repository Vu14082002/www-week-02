package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "customer")
@NamedQueries({
        @NamedQuery(name = "customer.findCustomerByIdJoinFetch",
                query = "select c  from Customer c join FETCH c.orderList where c.id =:id"
        ),
        @NamedQuery(name = "customer.findAll", query = "select c from Customer  c"),
        @NamedQuery(name = "customer.findByEmail", query = "select c from Customer c where c.email= :email"),
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

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Order> orderList;

    public Customer(String address, String email, String name, String phone) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    public void addOrder(Order order) {
        if (this.orderList == null) {
            this.orderList = new ArrayList<>();
        }
        this.orderList.add(order);
        order.setCustomer(this);
    }

    @PreRemove
    private void remove() {
        this.orderList.forEach(e -> e.setCustomer(null));
    }
}
