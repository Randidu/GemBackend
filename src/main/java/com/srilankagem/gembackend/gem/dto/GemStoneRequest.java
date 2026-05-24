package com.srilankagem.gembackend.gem.dto;
import com.srilankagem.gembackend.gem.models.GemOrigin;
import com.srilankagem.gembackend.gem.models.GemTreatment;
import com.srilankagem.gembackend.gem.models.GemType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GemStoneRequest {

    @NotBlank(message = "Gem code is required")
    @Size(min = 3,max = 30,message = "gem code must be between 3 to 300 letters")
    private String gemCode;

    @NotBlank(message = "Gem type is required")
    private GemType type;

    @NotBlank(message = "Gem color is required")
    private String color;

    @NotBlank
    @DecimalMin(value = "0.01",message = "value must be greater than 0.01")
    private Double caratWeight;

    @NotBlank(message = "Gem origin is required")
    private GemOrigin origin;

    @NotBlank(message = "Gem treatment is required")
    private GemTreatment treatment;

    @NotBlank
    @DecimalMin(value = "0.01",message = "value must be greater than 0.01" )
    private Double pricePreCarat;

    @NotBlank
    @Min(value =0,message = "value must be greater than 0")
    private Integer stockQuantity;

    @NotBlank
    @Size(max = 1000)
    private String description;


    private boolean certified;


}
