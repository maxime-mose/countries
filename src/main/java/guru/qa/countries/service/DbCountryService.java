package guru.qa.countries.service;

import guru.qa.countries.data.CountryEntity;
import guru.qa.countries.data.CountryRepository;
import guru.qa.countries.dto.CountryDto;
import guru.qa.countries.dto.UpdateCountryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbCountryService implements CountryService {

  private final CountryRepository countryRepository;

  @Autowired
  public DbCountryService(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  @Override
  public List<CountryDto> getAll() {
    return countryRepository.findAll()
        .stream()
        .map(entity -> new CountryDto(entity.getId(), entity.getName()))
        .toList();
  }

  @Override
  public void create(CountryDto country) {
    if (!countryRepository.existsById(country.id())) {
      countryRepository.save(new CountryEntity(country.id(), country.name()));
    }
  }

  @Override
  public void update(String id, UpdateCountryDto country) {
    countryRepository.findById(id)
        .stream()
        .peek(entity -> entity.setName(country.name()))
        .forEach(countryRepository::save);
  }
}
