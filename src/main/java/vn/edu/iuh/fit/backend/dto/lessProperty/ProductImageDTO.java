package vn.edu.iuh.fit.backend.dto.lessProperty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductImageDTO {
    private long image_id;
    private String alternative;
    private String path;
    private long productProduct_id;
}
