package devlab.controllers;

import devlab.commons.annotations.ApiVersion1;
import devlab.models.dtos.PlanetDto;
import devlab.services.PlanetService;

import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@CrossOrigin
@RestController
@ApiVersion1
public class PlanetController {

  private PlanetService planetService;

  public PlanetController(PlanetService planetService) {
    this.planetService = planetService;
  }

  @GetMapping("/planets")
  public List<PlanetDto> getPlanets() {
    return planetService.getPlanetsDto();
  }

}
