package com.codeup.codeupspringblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codeup.codeupspringblog.model.*;

public interface AdUserRepository extends JpaRepository<AdUser, Long> {
    AdUser findUserById(long id);
    AdUser findByUsername(String username);
}
