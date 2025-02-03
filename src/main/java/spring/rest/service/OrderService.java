package spring.rest.service;

import spring.rest.model.Order;

import java.util.List;

public interface OrderService {
    void create(Order order);

    List<Order> readAll();

    Order read(Integer id);

    boolean update(Order order, Integer id);

    boolean delete(Integer id);
}
