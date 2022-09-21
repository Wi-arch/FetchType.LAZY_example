package com.example.repository;

import com.example.entity.UserAccountEntity;
import com.example.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccountEntity, Long> {
}
