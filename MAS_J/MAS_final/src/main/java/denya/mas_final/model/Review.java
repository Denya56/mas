package denya.mas_final.model;


import denya.mas_final.model.enums.Rating;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Size(min = 2, max = 100)
    private String title;

    @NotNull(message = "Rating is mandatory")
    @Enumerated(value = EnumType.STRING)
    private Rating rating;

    @NotBlank(message = "Content is mandatory")
    @Size(min = 2, max = 2000)
    private String content;

    @ManyToOne(optional = false)
    @JoinColumn(name = "productOrder_id", nullable = false, updatable = false)
    @Setter(AccessLevel.PRIVATE)
    private ProductOrder productOrder;

}
