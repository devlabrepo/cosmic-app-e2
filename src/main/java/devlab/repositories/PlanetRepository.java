package devlab.repositories;

import devlab.models.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

//@Query(value = "select * from planets where distance_from_sun <= ?1", nativeQuery = true) //SQL
  @Query("select p from Planet p where p.distanceFromSun <= ?1")
  List<Planet> findPlanetsByDistanceFromSun(Long distance);

}
