package denya.mas_final.model;

import denya.mas_final.model.enums.Genres;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Game extends ProductBase {

    @ElementCollection
    @CollectionTable(name = "genres", joinColumns = @JoinColumn(name = "game_id"))
    private Set<Genres> genres;
}
