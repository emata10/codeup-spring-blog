package com.codeup.codeupspringblog.services;

import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.models.UserWithRoles;
import com.codeup.codeupspringblog.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDetailsLoader implements UserDetailsService {
    private final UserRepository usersDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        return new UserWithRoles(user);
    }
}
