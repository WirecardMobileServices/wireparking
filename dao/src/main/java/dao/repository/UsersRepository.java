package dao.repository;

import domainn.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository  extends JpaRepository<Users,Integer>{
    Optional<List<Users>> findByfirstName(String name);
}
