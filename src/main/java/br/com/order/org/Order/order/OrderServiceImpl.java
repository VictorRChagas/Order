package br.com.order.org.Order.order;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderData orderData;

    public OrderServiceImpl(OrderData orderData) {
        this.orderData = orderData;
    }

    @Override
    public Order save(final Order order) {
        this.preSave(order);
        return orderData.save(order);
    }

    private void preSave(final Order order) {
        final NewOrderHandler newOrderHandler = new NewOrderHandler(order);
        newOrderHandler.handleOrder();
    }

    @Override
    public List<Order> listAll() {
        return orderData.findAll();
    }

    @Override
    public Optional<Order> findOne(final Long id) {
        return orderData.findById(id);
    }

    @Override
    public boolean deleteById(final Long id) {
        final Optional<Order> user = this.findOne(id);
        if (user.isPresent()) {
            orderData.deleteById(id);
            return true;
        }
        return false;
    }
}
