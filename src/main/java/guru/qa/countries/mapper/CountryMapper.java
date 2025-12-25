package guru.qa.countries.mapper;

import guru.qa.countries.data.CountryEntity;
import guru.qa.countries.dto.CountryDto;

public class CountryMapper {

  public static CountryDto toDto(CountryEntity country) {
    return new CountryDto(country.getCode(), country.getName());
  }

  public static CountryEntity toEntity(CountryDto dto) {
    return CountryEntity.builder().code(dto.code()).name(dto.name()).build();
  }
}
