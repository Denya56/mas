package mas.denys.mas_mp5.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Fighter extends Player {

    @Min(1)
    private double strength;
}
