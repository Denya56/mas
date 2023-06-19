package denya.mas_final.model;


import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PhysicalCopy extends ProductCopy {

    @ElementCollection
    @CollectionTable(name = "contents", joinColumns = @JoinColumn(name = "physicalCopy_id"))
    @NotNull
    private List<String> contents;

    @NotBlank(message = "Physical size is mandatory")
    @Size(min = 2, max = 150)
    private String physicalSize;

    @NotBlank(message = "Weight is mandatory")
    @Size(min = 2, max = 50)
    private String weight;
}
