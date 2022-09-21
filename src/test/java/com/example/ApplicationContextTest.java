package com.example;

import com.example.entity.UserAccountEntity;
import com.example.entity.UserEntity;
import com.example.repository.UserAccountRepository;
import com.example.repository.UserRepository;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ApplicationContextTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAccountRepository userAccountRepository;
    private Long id;

    @BeforeEach
    public void setUp() {
        UserEntity userEntity = new UserEntity();
        userEntity.setIin(123451234512L);
        userEntity = userRepository.save(userEntity);

        UserAccountEntity userAccountEntity = new UserAccountEntity();
        userAccountEntity.setUserEntity(userEntity);
        id = userAccountRepository.save(userAccountEntity).getId();
    }

    @Test
    public void testLazyLoad() {
        assertNotNull(id);

        UserAccountEntity userAccountEntity = userAccountRepository.findById(id).orElseThrow();
        assertThrows(LazyInitializationException.class, userAccountEntity::getUserEntity);
    }
}
