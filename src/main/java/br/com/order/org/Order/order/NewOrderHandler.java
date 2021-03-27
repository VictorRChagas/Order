package br.com.order.org.Order.order;

import br.com.order.org.Order.user.User;

import java.time.LocalDateTime;

public class NewOrderHandler {

    private final Order order;

    public NewOrderHandler(final Order order) {
        this.order = order;
    }

    public void handleOrder() {
        this.order.setMoment(LocalDateTime.now());
        this.order.setStatus(OrderStatus.WAITING_PAYMENT);
        this.order.setUser(new User(order.getUserId()));
    }
}
