package com.mitrais.cdc.repository;

import com.mitrais.cdc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {
    User findByUsername(String username);
    Optional<User> findByEmail(String email);
}
