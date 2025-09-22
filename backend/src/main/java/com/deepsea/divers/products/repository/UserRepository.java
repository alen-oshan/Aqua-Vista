package com.deepsea.divers.products.repository;

import com.deepsea.divers.products.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    // Specify the methods that is not in-build in JPA
    Optional<User> findByEmail(String email);
}
