package spring.rest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import spring.rest.model.MyUser;

public interface UserRepository extends JpaRepository<MyUser, Integer> {
}
