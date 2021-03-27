package br.com.order.org.Order.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderData extends JpaRepository<Order, Long> {
}
