package denya.mas_final.model;

import denya.mas_final.model.enums.DeliveryType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @PastOrPresent
    private LocalDate purchaseDate;

    @NotBlank(message = "Address is mandatory")
    @Size(min = 2, max = 200)
    private String address;

    @NotNull(message = "Delivery type is mandatory")
    @Enumerated(value = EnumType.STRING)
    private DeliveryType deliveryType;

    @OneToMany(mappedBy = "productOrder", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.PRIVATE)
    private Set<Review> reviews = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "shopUser_id", nullable = false)
    @NotNull(message = "user cannot be null")
    private ShopUser shopUser;

    @ManyToOne
    @JoinColumn(name = "productCopy_id", nullable = false)
    @NotNull(message = "product cannot be null")
    private ProductCopy productCopy;

    public double getTotalPrice() {
        return productCopy.getPrice() * productCopy.getQuantity();
    }
}
