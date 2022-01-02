package com.company.urlshortener.shortUrlService;

import com.company.urlshortener.shortUrlService.model.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrl, UUID> {

    ShortUrl findByHash(String hash);

    void deleteByHash(String hash);

}
