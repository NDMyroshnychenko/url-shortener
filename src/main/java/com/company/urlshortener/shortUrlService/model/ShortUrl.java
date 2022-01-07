package com.company.urlshortener.shortUrlService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "short_url")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShortUrl {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "hash", nullable = false, unique = true)
    private String hash;

    @Column(name = "original_url", unique = true)
    private String originalUrl;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private ZonedDateTime createdAt;

    public static ShortUrl create(String hash, String originalUrl) {
        return ShortUrl.builder()
                .hash(hash)
                .originalUrl(originalUrl)
                .createdAt(ZonedDateTime.now())
                .build();
    }

    @Override
    public String toString() {
        return "ShortUrl{" +
                "id=" + id +
                ", hash='" + hash + '\'' +
                ", originalUrl='" + originalUrl + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    //    private User user;

}
