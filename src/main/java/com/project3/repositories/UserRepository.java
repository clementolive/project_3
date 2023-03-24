package com.project3.repositories;

import com.project3.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select count(p) = 1 from User p where name = ?1")
    public boolean existsByname(String name);

    @Query("select count(p) = 1 from User p where email = ?1")
    public boolean existsByEmail(String email);

    org.springframework.security.core.userdetails.User findByEmail(String email);

    public User findByName(String name);
}
