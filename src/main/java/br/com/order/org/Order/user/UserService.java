package br.com.order.org.Order.user;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    List<User> listAll();

    Optional<User> findOne(Long id);

    boolean deleteById(Long id);
}
