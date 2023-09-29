package vn.edu.iuh.fit.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@IdClass(OrderDetailCompositeId.class)
@Table(name = "order_detail")
@NamedQueries({
        @NamedQuery(name = "order_detail.findAll", query = "select od  from OrderDetail od"),
        @NamedQuery(name = "order_detail.findById",
                query = "select od  from OrderDetail od where od.order.id=:orderID and od.product.id= :procId"),
})
public class OrderDetail {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

    @Column(name = "quantity", nullable = false)
    private double quantity;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "note")
    private String note;

}
