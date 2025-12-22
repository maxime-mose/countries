package guru.qa.countries.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateCountryDto(
    @NotNull
    @Size(min = 1, max = 255)
    String name
) {
}
