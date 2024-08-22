package com.mindhub.todolist;

import com.mindhub.todolist.models.RolEnum;
import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.repositories.UserRepository;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
@ActiveProfiles("test")
public class UserEntityRepositoryEmail {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByEmail(){
        UserEntity user = new UserEntity("usertest", "password", "testuser@gmail.com");
        user.setRol(RolEnum.USER);
        userRepository.save(user);

        Optional<UserEntity> foundUser = userRepository.findByEmail(user.getEmail());

        assertThat(foundUser, is(notNullValue()));
        assertThat(foundUser.get().getEmail(), is(equalTo(user.getEmail())));
        assertThat(foundUser.get().getPassword(), is(equalTo(user.getPassword())));
        assertThat(foundUser.get().getUsername(), is(equalTo(user.getUsername())));
        assertThat(foundUser.get().getRol(), is(equalTo(user.getRol())));

    }

}
