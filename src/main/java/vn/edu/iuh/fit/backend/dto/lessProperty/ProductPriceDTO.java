package vn.edu.iuh.fit.backend.dto.lessProperty;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductPriceDTO {
    private LocalDateTime price_date_time;

    private String note;

    private double price;

    private long productProduct_id;
}
