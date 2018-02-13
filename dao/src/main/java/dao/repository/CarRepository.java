package dao.repository;


import domainn.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Cars,Integer> {
    Optional<List<Cars>> findBymanufacturer(String name);
}
