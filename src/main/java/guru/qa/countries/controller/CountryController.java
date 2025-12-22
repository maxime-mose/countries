package guru.qa.countries.controller;

import guru.qa.countries.dto.CountryDto;
import guru.qa.countries.dto.UpdateCountryDto;
import guru.qa.countries.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/country")
public class CountryController {

  private final CountryService countryService;

  @Autowired
  public CountryController(CountryService countryService) {
    this.countryService = countryService;
  }

  @GetMapping("all")
  public List<CountryDto> getAll() {
    return countryService.getAll();
  }

  @PostMapping("create")
  public void create(@Valid @RequestBody CountryDto country) {
    countryService.create(country);
  }

  @PutMapping("update/{id}")
  public void update(@PathVariable("id") String id, @Valid @RequestBody UpdateCountryDto country) {
    countryService.update(id, country);
  }
}
