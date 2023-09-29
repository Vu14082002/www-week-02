package vn.edu.iuh.fit.backend.models;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailCompositeId implements Serializable {
    private long order;
    private long product;
}
