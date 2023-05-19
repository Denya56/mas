package mas.denys.mas_mp5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"mage_id", "guild_id"})
})
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mage_id", nullable = false)
    @NotNull
    private Mage mage;

    @ManyToOne
    @JoinColumn(name = "guild_id", nullable = false)
    @NotNull
    private Guild guild;

    @NotNull
    private LocalDate startDate;

    private LocalDate endDate;
}
