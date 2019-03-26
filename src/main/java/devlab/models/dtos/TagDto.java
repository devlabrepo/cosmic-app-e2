package devlab.models.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class TagDto {

  private String title;
  private List<String> planets = new ArrayList<>();
}
