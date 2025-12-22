package guru.qa.countries.service;

import guru.qa.countries.dto.CountryDto;
import guru.qa.countries.dto.UpdateCountryDto;

import java.util.List;

public interface CountryService {

  List<CountryDto> getAll();

  void create(CountryDto country);

  void update(String id, UpdateCountryDto country);
}
