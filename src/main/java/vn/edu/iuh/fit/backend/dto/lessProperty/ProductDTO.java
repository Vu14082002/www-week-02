package vn.edu.iuh.fit.backend.dto.lessProperty;

import lombok.*;
import vn.edu.iuh.fit.backend.models.ProductImage;
import vn.edu.iuh.fit.backend.models.ProductPrice;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO {
    private long product_id;
    private String description;
    private String manufacturer;
    private String name;
    private String status;
    private String unit;
}
