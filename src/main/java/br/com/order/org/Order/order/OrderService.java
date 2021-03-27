package br.com.order.org.Order.order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order save(Order order);

    List<Order> listAll();

    Optional<Order> findOne(Long id);

    boolean deleteById(Long id);
}
