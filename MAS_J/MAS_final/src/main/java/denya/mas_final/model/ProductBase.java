package denya.mas_final.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ProductBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 100)
    @Column(unique=true)
    private String name;

    @NotBlank(message = "Description is mandatory")
    @Size(min = 2, max = 500)
    private String description;

    @NotNull(message = "Release date has to be specified")
    private LocalDate releaseDate;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 100)
    private String developer;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 100)
    private String publisher;

    @OneToMany(mappedBy = "baseProduct")
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ProductCopy> copies = new HashSet<>();
}
