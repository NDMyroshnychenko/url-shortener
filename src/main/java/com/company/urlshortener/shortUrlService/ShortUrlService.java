package com.company.urlshortener.shortUrlService;

import com.company.urlshortener.util.CodeGenerator;
import com.company.urlshortener.shortUrlService.model.ShortUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShortUrlService {

    @Autowired
    private CodeGenerator codeGenerator;

    @Autowired
    private ShortUrlRepository repository;

    private Logger logger = LoggerFactory.getLogger(ShortUrlService.class);

    public String createShortUrl(String original) {
        if (original == null) {
            return null;
        }
        int shorterLength = 6;
        String hash = codeGenerator.generate(shorterLength);
        logger.info(hash);
//todo  декодирование строки нужно?
//            String shorterString = URLDecoder.decode(shorter.getOriginalUrl());
//            logger.info(shorterString);
            ShortUrl shortUrl = ShortUrl.create(hash, original);
            repository.save(shortUrl);
            return shortUrl.getHash();
    }

    public List<ShortUrl> getAll() {
        List<ShortUrl> shortUrls = repository.findAll();
        logger.info(String.valueOf(shortUrls));
        return shortUrls;
    }

    public ShortUrl findByHash(String hash) {
        return repository.findByHash(hash);
    }

    @Transactional
    public void deleteByHash(String hash) {
        repository.deleteByHash(hash);

    }
}
