package denya.mas_final.model;


import denya.mas_final.customConstraints.ValidConsoleFields;
import denya.mas_final.customConstraints.ValidPCFields;
import denya.mas_final.model.enums.ProductPlatform;
import denya.mas_final.model.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@ValidConsoleFields
@ValidPCFields
public abstract class ProductCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Min(0)
    @Max(9999)
    private double price;

    @NotNull(message = "Delivery type is mandatory")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Min(1)
    private int quantity;

    @NotNull(message = "Product type is mandatory")
    @Enumerated(value = EnumType.STRING)
    private ProductPlatform productPlatform;

    @Size(min = 2, max = 150)
    private String minRequirements;

    @Size(min = 2, max = 150)
    private String recommendedRequirements;

    @Size(min = 2, max = 50)
    private String consoleName;

    @Size(min = 1, max = 50)
    private String consoleGeneration;

    @ManyToOne
    @JoinColumn(name = "productBase_id", updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NotNull(message = "Base product is mandatory")
    private ProductBase baseProduct;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NotNull
    private ShopUser seller;

    @OneToMany(mappedBy = "productCopy", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ProductOrder> productOrders;
}
