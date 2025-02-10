package spring.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.rest.model.MyUser;
import spring.rest.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(MyUser myUser) {
        userRepository.save(myUser);
    }

    @Override
    public List<MyUser> readAll() {
        return userRepository.findAll();
    }

    @Override
    public MyUser read(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public boolean update(MyUser myUser, Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.save(myUser);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
