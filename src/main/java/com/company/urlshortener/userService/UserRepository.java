package com.company.urlshortener.userService;

import com.company.urlshortener.userService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository <User, UUID> {

    @Query("select u from User u join fetch u.role where u.login =:login")
    User findByLogin(@Param("login")String login);

}
