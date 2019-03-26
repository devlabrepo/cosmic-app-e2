package devlab.models.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class PlanetDto {

  private String planetName;
  private long distanceFromSun;
  private double oneWayLightTimeToTheSun;
  private long lengthOfYear;
  private String planetType;
  private String planetInfo;
  private String planetImage;
  private List<String> tags = new ArrayList<>();
}
