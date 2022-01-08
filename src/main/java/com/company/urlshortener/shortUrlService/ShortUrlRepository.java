package com.company.urlshortener.shortUrlService;

import com.company.urlshortener.shortUrlService.model.ShortUrl;
import com.company.urlshortener.userService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrl, UUID> {

    ShortUrl findByHash(String hash);

    @Modifying
    @Query("delete FROM ShortUrl s WHERE s.hash =:hash")
    void deleteByHash(@Param("hash") String hash);

    ShortUrl findByOriginalUrl(String original);

    ShortUrl findByOriginalUrlAndUser(String original, User user);

    @Query("select s from ShortUrl s join fetch s.user u where u.login =:login")
    List<ShortUrl> findAllByUserLogin(@Param("login") String login);

}
