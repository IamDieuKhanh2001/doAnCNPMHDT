package com.example.demospringsecurity.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.demospringsecurity.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUserName(String username) {
        return getApplicationUser()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }
    private List<ApplicationUser> getApplicationUser(){
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        "khanh",
                        passwordEncoder.encode("password"),
                        STUDENT.GetGrantedAuthorities()
                )
//                new ApplicationUser(
//                        "linda",
//                        passwordEncoder.encode("password"),
//                        ADMIN.GetGrantedAuthorities(),
//                        true,
//                        true,
//                        true,
//                        true
//                ),
//                new ApplicationUser(
//                        "tom",
//                        passwordEncoder.encode("password"),
//                        ADMINTRAINEE.GetGrantedAuthorities(),
//                        true,
//                        true,
//                        true,
//                        true
//                )
        );
        return applicationUsers;
    }
}
