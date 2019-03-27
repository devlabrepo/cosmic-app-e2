package devlab.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data //todo - zmienic na gett sett const
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tags")
public class Tag {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title")
  private String title;

  @JsonIgnore
  @ManyToMany(mappedBy = "tags")
  Set<Planet> planets = new HashSet<>();

}
