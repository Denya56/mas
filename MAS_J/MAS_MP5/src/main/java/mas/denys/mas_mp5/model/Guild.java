package mas.denys.mas_mp5.model;


import jakarta.persistence.*;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Guild {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 255)
    private String name;

    @Min(1)
    private int level;

    @Min(0)
    private double totalGold;

    @OneToMany(mappedBy = "guild", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Membership> memberships;

    @OneToMany(mappedBy = "guild", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.PRIVATE)
    private Set<GuildUnit> guildUnits = new HashSet<>();
}
