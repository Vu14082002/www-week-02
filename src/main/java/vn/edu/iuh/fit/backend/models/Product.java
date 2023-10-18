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
                @NamedQuery(name = "product.findByIdJoinFetch",
                query = "select p from Product p " +
                        "join fetch p.productImageList join fetch p.productPrices join fetch p.orderDetails " +
                        "where p.id= :id"
                ),
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

    @OneToMany(mappedBy = "product", cascade = {CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.DETACH, CascadeType.REFRESH})
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.DETACH, CascadeType.REFRESH})
    private List<ProductImage> productImageList;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.DETACH, CascadeType.REFRESH})
    private List<ProductPrice> productPrices;

    public void addOrderDetail(OrderDetail orderDetail) {
        if (this.orderDetails == null) {
            this.orderDetails = new ArrayList<>();
        }
        this.orderDetails.add(orderDetail);
        orderDetail.setProduct(this);
    }

    public void addOrderProductPrice(ProductPrice productPrice) {
        if (this.productPrices == null) {
            this.productPrices = new ArrayList<>();
        }
        this.productPrices.add(productPrice);
        productPrice.setProduct(this);
    }

    public void addProductImage(ProductImage productImage) {
        if (this.productImageList == null) {
            this.productImageList = new ArrayList<>();
        }
        this.productImageList.add(productImage);
        productImage.setProduct(this);
    }
    @PreRemove
    public void remove(){
        this.orderDetails.forEach(e->e.setProduct(null));
    }
}
