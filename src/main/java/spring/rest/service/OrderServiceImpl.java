package spring.rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.rest.model.Order;
import spring.rest.model.User;
import spring.rest.repository.OrderRepository;
import spring.rest.repository.UserRepository;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void create(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> readAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order read(Integer id) {
        return orderRepository.getOne(id);
    }

    @Override
    public boolean update(Order order, Integer id) {
        if (orderRepository.existsById(id)) {
            orderRepository.save(order);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
