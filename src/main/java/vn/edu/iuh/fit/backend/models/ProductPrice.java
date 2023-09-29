package vn.edu.iuh.fit.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "product_price")
@NamedQueries(
        {
                @NamedQuery(name = "product_price.findAll", query = "select pp from ProductPrice pp"),
        }
)
public class ProductPrice {
    @Id
    @Column(name = "price_date_time")
    private LocalDateTime price_date_time;

    @Column(name = "note")
    private String note;

    @Column(name = "price", nullable = false)
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

    @PrePersist
    public void setPriceCurrentTime() {
        price_date_time = LocalDateTime.now();
    }
}
