package mas.denys.mas_mp5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class GuildUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "guild_id", nullable = false, updatable = false)
    @Setter(AccessLevel.PRIVATE)
    private Guild guild;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 255)
    private String name;
}
