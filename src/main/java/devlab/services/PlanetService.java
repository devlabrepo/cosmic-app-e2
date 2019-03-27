package devlab.services;

import devlab.mappers.PlanetMapper;
import devlab.models.Planet;
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

  public void deletePlanetByName(String name) {
    planetRepository.deleteByPlanetName(name);
  }

  public Planet addPlanet(PlanetDto planetDto) {
    return planetRepository.save(planetMapper.reverse(planetDto));
  }

  public void updatePlanet(PlanetDto planetDto) {
    planetRepository
            .findPlanetByPlanetName(planetDto.getPlanetName())
            .ifPresent(p -> {
              p.setDistanceFromSun(planetDto.getDistanceFromSun());
              p.setOneWayLightTimeToTheSun(planetDto.getOneWayLightTimeToTheSun());
              p.setLengthOfYear(planetDto.getLengthOfYear());
              p.setPlanetType(planetDto.getPlanetType());
              p.setPlanetInfo(planetDto.getPlanetInfo());
              p.setPlanetImage(planetDto.getPlanetImage());
              planetRepository.save(p);
            });
  }

}
