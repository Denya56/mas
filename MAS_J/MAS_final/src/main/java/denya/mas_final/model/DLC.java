package denya.mas_final.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DLC extends ProductBase {

    @NotBlank(message = "Required game name is mandatory")
    @Size(min = 2, max = 100)
    private String requiredGameName;
}
