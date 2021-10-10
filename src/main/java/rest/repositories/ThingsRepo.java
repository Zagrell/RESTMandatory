package rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.models.Thing;

public interface ThingsRepo extends JpaRepository<Thing, Long> {
}
