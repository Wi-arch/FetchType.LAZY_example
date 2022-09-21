package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "jusan_user")
public class UserEntity extends BaseEntity {

    @Column(name = "iin", nullable = false, unique = true)
    private Long iin;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserAccountEntity> userAccounts;
}
