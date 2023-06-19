package denya.mas_final.model;

import jakarta.persistence.Column;
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
public class DigitalCopy extends ProductCopy {

    @NotBlank(message = "Activation code is mandatory")
    @Size(min = 2, max = 20)
    @Column(unique = true)
    private String activationCode;
}
