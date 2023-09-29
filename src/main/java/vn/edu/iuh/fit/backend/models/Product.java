package vn.edu.iuh.fit.backend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.backend.enums.ProductStatus;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "product")
@NamedQueries(
        {
                @NamedQuery(name = "product.findAll", query = "select p from Product p where p.status = 1"),
                @NamedQuery(name = "product.findTopProcNew",
                        query = "SELECT p FROM Product p ORDER BY p.product_id DESC")
        }
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long product_id;

    @Column(name = "description", length = 250, nullable = false)
    private String description;

    @Column(name = "manufacturer_name", length = 100, nullable = false)
    private String manufacturer;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Column(name = "status", nullable = false)
    private ProductStatus status;

    @Column(name = "unit", length = 25, nullable = false)
    private String unit;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ProductImage> productImageList = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ProductPrice> productPrices = new ArrayList<>();
}
