package br.com.order.org.Order.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserData userData;

    public UserServiceImpl(UserData userData) {
        this.userData = userData;
    }

    @Override
    public User save(User user) {
        return userData.save(user);
    }

    @Override
    public List<User> listAll() {
        return userData.findAll();
    }

    @Override
    public Optional<User> findOne(Long id) {
        return userData.findById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        final Optional<User> user = this.findOne(id);
        if (user.isPresent()) {
            userData.deleteById(id);
            return true;
        }
        return false;
    }
}
