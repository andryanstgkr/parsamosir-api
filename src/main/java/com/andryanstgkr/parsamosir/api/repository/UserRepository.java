package com.andryanstgkr.parsamosir.api.repository;

import java.util.Optional;

import com.andryanstgkr.parsamosir.api.model.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long>{

    @Query("from User u where u.id = ?1")
    public Optional<User> findUserById(String id);

    @Query("from User u where u.userName like ?1%")
    public Optional<User> findUserByUserName(String userName);
}
