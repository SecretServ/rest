package spring.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.rest.model.Order;


public interface OrderRepository extends JpaRepository<Order, Integer> {

}
