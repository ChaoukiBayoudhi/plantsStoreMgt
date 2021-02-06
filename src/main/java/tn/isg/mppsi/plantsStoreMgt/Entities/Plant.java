package tn.isg.mppsi.plantsStoreMgt.Entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Plant {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private BigDecimal price;
    @NonNull
    private String origin;


}
