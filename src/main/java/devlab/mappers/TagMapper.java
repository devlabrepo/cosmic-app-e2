package devlab.mappers;

import devlab.commons.Mapper;
import devlab.models.Planet;
import devlab.models.Tag;
import devlab.models.dtos.TagDto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TagMapper implements Mapper<Tag, TagDto> {

  @Override
  public TagDto map(Tag from) {
    List<String> planets = from
            .getPlanets()
            .stream()
            .map(PlanetsToStringsList.INSTANCE)
            .collect(Collectors.toList());

    return TagDto
            .builder()
            .title(from.getTitle())
            .planets(planets)
            .build();
  }

  @Override
  public Tag reverse(TagDto to) {
    return null;
  }


  private enum PlanetsToStringsList implements Function<Planet, String> {
    INSTANCE;

    public String apply(Planet planet) {
      return planet.getPlanetName();
    }

  }
}
