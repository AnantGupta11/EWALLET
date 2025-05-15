package org.infy.UserServiceApplication.repositiory;

import org.infy.UserServiceApplication.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositiory extends JpaRepository<Users,Integer> {

    Users findByContact(String contact);
}
