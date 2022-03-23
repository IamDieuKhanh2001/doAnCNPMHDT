package com.example.demospringsecurity.auth;

import com.example.demospringsecurity.Book.Books;
import com.example.demospringsecurity.entity.DAOUser;
import com.example.demospringsecurity.entity.UserDTO;
import com.example.demospringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public ApplicationUserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<DAOUser> user = userRepository.findDAOUsersByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return user.map(ApplicationUser::new).get();
//        return applicationUserDao
//                .selectApplicationUserByUserName(username)
//                .orElseThrow(() ->
//                        new UsernameNotFoundException(String.format("Username %s not found!", username)));
    }
    public DAOUser save(UserDTO user) {
        DAOUser newUser = new DAOUser();
        Optional<DAOUser> DAOUserOptional = userRepository.findDAOUsersByUsername(user.getUsername());
        if(DAOUserOptional.isPresent()){
            throw new IllegalStateException("Username have present in db");
        }
        //Nếu không trùng username, encode pwd và lưu vào db customer
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRole(user.getRole());
        return userRepository.save(newUser);
    }
}
