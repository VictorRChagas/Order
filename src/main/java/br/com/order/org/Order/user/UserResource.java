package br.com.order.org.Order.user;

import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.listAll();
    }

    @GetMapping("{id}")
    public User findOne(@PathVariable("id") Long id) throws NotFoundException {
        return userService.findOne(id)
                .orElseThrow(() -> new NotFoundException("User not found!"));
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return userService.deleteById(id);
    }
}
