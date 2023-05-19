package mas.denys.mas_mp5.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemBag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 255)
    private String name;

    @ElementCollection
    @CollectionTable(name = "items", joinColumns = @JoinColumn(name = "itemBag_id"))
    private List<String> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "player_id", updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Player belongsTo;
}
