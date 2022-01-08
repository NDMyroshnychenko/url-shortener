package com.company.urlshortener.shortUrlService;

import com.company.urlshortener.shortUrlService.model.ShortUrl;
import com.company.urlshortener.userService.UserServiceImpl;
import com.company.urlshortener.userService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class ShortUrlController {

    @Autowired
    ShortUrlService shortUrlService;

    @Autowired
    UserServiceImpl userService;

    @PostMapping(path = "/")
    public String createShortUrl(String original, RedirectAttributes redirectAttributes, Principal principal) {
        User user = userService.findByLogin(principal.getName());
        String hash = shortUrlService.createShortUrl(original, user);
        String shortUrl = "http://localhost:8080" + "/" + hash;
        redirectAttributes.addFlashAttribute("shortUrl", shortUrl);
        return "redirect:/";
    }

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        String loginCurrentUser = principal.getName();
        List<ShortUrl> listShortUrls = shortUrlService.getAllByLogin(loginCurrentUser);
        model.addAttribute("listShortUrls", listShortUrls);
        return "/index";
    }

    @GetMapping(path = "/{hash}")
    public ResponseEntity redirectShorter(@PathVariable("hash") String hash) {
        ShortUrl shortUrl = shortUrlService.findByHash(hash);
        if (shortUrl != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", shortUrl.getOriginalUrl());
            return new ResponseEntity<String>(headers, HttpStatus.FOUND);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping(path = "/delete/{hash}")
    public String deleteShorter(@PathVariable("hash") String hash) {
        shortUrlService.deleteByHash(hash);
      return "redirect:/";
    }
}
