package spring.rest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import spring.rest.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
