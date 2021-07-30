package com.zuk.repository;

import com.zuk.model.Role;
import com.zuk.model.User;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
    User findByEmail(String email);


    User findByUsernameContains(String name);
    User findByEmailContains(String email);


    List<User> findByRolesEquals(Role role);


    User getByIdAndRolesEquals(Long id, Role role);

}
