package vn.edu.iuh.fit.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
@NamedQueries({
        @NamedQuery(name = "order.findAll", query = "select o from Order o"),
        @NamedQuery(name = "order.findOrderByIdJoinFetch", query = "select o from Order o join o.orderDetails where o.id= :id"),
        @NamedQuery(name = "order.getOrdersByEmpId", query = "SELECT o from Order o WHERE  o.employee.id = :id "),
})
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,
                            CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    private List<OrderDetail> orderDetails;


    public Order(LocalDateTime orderDate, Customer customer, Employee employee) {
        this.orderDate = orderDate;
        this.customer = customer;
        this.employee = employee;
    }

    @PreRemove
    public void remove(){
        this.setEmployee(null);
        this.orderDetails.forEach(e->e.setOrder(null));
    }
    public void addOrderDetail(OrderDetail orderDetail){
        if(this.orderDetails ==null){
            this.orderDetails = new ArrayList<>();
        }
       this.orderDetails.add(orderDetail);
        orderDetail.setOrder(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return getId() == order.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", employee=" + employee +
                '}';
    }
}
