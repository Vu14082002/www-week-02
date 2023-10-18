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
@Table(name = "product_image")
@NamedQueries(
        {
                @NamedQuery(name = "product_image.findAll", query = "select procImage from ProductImage procImage"),
        }
)
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private long image_id;

    @Column(name = "alternative",length = 250)
    private String alternative;

    @Column(name = "path",length = 250,nullable = false)
    private String path;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    private Product product;
}
