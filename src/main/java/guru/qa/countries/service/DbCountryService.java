package guru.qa.countries.service;

import guru.qa.countries.data.CountryRepository;
import guru.qa.countries.dto.CountryDto;
import guru.qa.countries.dto.UpdateCountryDto;
import guru.qa.countries.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static guru.qa.countries.mapper.CountryMapper.toDto;
import static guru.qa.countries.mapper.CountryMapper.toEntity;

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
        .map(CountryMapper::toDto)
        .toList();
  }

  @Override
  public Optional<CountryDto> create(CountryDto country) {
    return countryRepository.existsById(country.code())
        ? Optional.empty()
        : Optional.of(toDto(countryRepository.save(toEntity(country))));
  }

  @Override
  public Optional<CountryDto> update(String code, UpdateCountryDto country) {
    return countryRepository.findById(code)
        .map(e -> e.toBuilder().name(country.name()).build())
        .map(countryRepository::save)
        .map(CountryMapper::toDto);
  }
}
