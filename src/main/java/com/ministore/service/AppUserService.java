
package com.ministore.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ministore.entity.AppUser;
import com.ministore.repository.AppUserRepository;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser registerUser(AppUser user) {
        if (appUserRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException(
                    "An account with this email already exists.");
        }

        user.setRole("USER");
        return appUserRepository.save(user);
    }

    public Optional<AppUser> findByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    public boolean emailExists(String email) {
        return appUserRepository.existsByEmail(email);
    }
}
