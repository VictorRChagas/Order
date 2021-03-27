package br.com.order.org.Order.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserData extends JpaRepository<User, Long> {
}
