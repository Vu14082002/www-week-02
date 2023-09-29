package vn.edu.iuh.fit.backend.dto.allProperty;

import lombok.*;
import vn.edu.iuh.fit.backend.models.OrderDetail;
import vn.edu.iuh.fit.backend.models.ProductImage;
import vn.edu.iuh.fit.backend.models.ProductPrice;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTOAllProperty {
    private long product_id;
    private String description;
    private String manufacturer;
    private String name;
    private String status;
    private String unit;
    private List<OrderDetail> orderDetails;
    private List<ProductImage> productImageList ;
    private List<ProductPrice> productPrices ;
}
