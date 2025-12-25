package guru.qa.countries.service;

import guru.qa.countries.dto.CountryDto;
import guru.qa.countries.dto.UpdateCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {

  List<CountryDto> getAll();

  Optional<CountryDto> create(CountryDto country);

  Optional<CountryDto> update(String code, UpdateCountryDto country);
}
