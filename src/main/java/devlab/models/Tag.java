package devlab.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data //todo - zmienic na gett sett const
@Entity
@Table(name = "tags")
public class Tag {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title")
  private String title;

  @ManyToMany(mappedBy = "tags")
  Set<Planet> planets = new HashSet<>();

}
