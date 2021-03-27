package br.com.order.org.Order.order;

import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderResource {

    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    @GetMapping
    public List<Order> findAll() {
        return orderService.listAll();
    }

    @GetMapping("{id}")
    public Order findOne(@PathVariable("id") Long id) throws NotFoundException {
        return orderService.findOne(id)
                .orElseThrow(() -> new NotFoundException("Order not found!"));
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return orderService.deleteById(id);
    }
}
