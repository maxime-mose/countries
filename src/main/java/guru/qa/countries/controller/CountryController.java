package guru.qa.countries.controller;

import guru.qa.countries.dto.CountryDto;
import guru.qa.countries.dto.UpdateCountryDto;
import guru.qa.countries.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/country")
public class CountryController {

  private final CountryService countryService;

  @Autowired
  public CountryController(CountryService countryService) {
    this.countryService = countryService;
  }

  @GetMapping
  public List<CountryDto> getAll() {
    return countryService.getAll();
  }

  @PostMapping
  public Optional<CountryDto> create(@Valid @RequestBody CountryDto country) {
    return countryService.create(country);
  }

  @PutMapping("{code}")
  public Optional<CountryDto> update(@PathVariable("code") String code, @Valid @RequestBody UpdateCountryDto country) {
    return countryService.update(code, country);
  }
}
