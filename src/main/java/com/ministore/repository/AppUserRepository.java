
package com.ministore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ministore.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    // Find a user by email for registration and login.
    Optional<AppUser> findByEmail(String email);

    // Check whether an email is already registered.
    boolean existsByEmail(String email);
}
