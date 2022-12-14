package com.todolist.demo.repository;

import com.todolist.demo.entity.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {        // Since it is a generic, we are passing the type (User) and the ID type (which is long)
    // We are just providing the interface, Spring will provide us with the implementation

    // if we want some special operations which are not there in CrudRepository, then we can include it here

    Optional<User> findByUsername(String username);
}
