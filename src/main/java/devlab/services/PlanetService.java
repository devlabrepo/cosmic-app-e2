package devlab.services;

import devlab.mappers.PlanetMapper;
import devlab.models.dtos.PlanetDto;
import devlab.repositories.PlanetRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PlanetService {

  private PlanetRepository planetRepository;
  private PlanetMapper planetMapper;

  public PlanetService(PlanetRepository planetRepository, PlanetMapper planetMapper) {
    this.planetRepository = planetRepository;
    this.planetMapper = planetMapper;
  }

  public List<PlanetDto> getPlanetsDto() {
    return planetRepository
            .findAll()
            .stream()
            .map(planetMapper::map)
            .collect(Collectors.toList());
  }

  public List<PlanetDto> getPlanetsDto(Long distance) {
    return planetRepository
            .findPlanetsByDistanceFromSun(distance)
            .stream()
            .map(planetMapper::map)
            .collect(Collectors.toList());
  }

}
