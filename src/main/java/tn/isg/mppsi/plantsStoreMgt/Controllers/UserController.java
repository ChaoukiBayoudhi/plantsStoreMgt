package tn.isg.mppsi.plantsStoreMgt.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.isg.mppsi.plantsStoreMgt.Entities.User;
import tn.isg.mppsi.plantsStoreMgt.Services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
public class UserController {
    @Autowired
    private UserService userServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public User addUser(@RequestBody User u1)
    {
        return userServ.add(u1);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public List<User> getAllUsers()
    {
        return userServ.getUsers();
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id)
    {
        return userServ.getUser(id);
    }
}
