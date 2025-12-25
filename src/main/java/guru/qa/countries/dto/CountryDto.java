package guru.qa.countries.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CountryDto(
    @NotNull
    @Size(min = 1, max = 3)
    String code,
    @NotNull
    @Size(min = 1, max = 255)
    String name
) {
}
