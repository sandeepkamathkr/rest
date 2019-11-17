package com.sandeepkamathkr.webservice.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.i18n.LocaleContextResolver;
import org.springframework.web.servlet.LocaleResolver;

@RequestMapping("/goods")
@RestController()
@RequiredArgsConstructor
public class HelloWorldEndPoint {

    private final MessageSource messageSource;

    @GetMapping()
    public ResponseEntity<String> getGoodMorning(){
        return ResponseEntity.ok(messageSource.getMessage("good.morning.text", null, LocaleContextHolder.getLocale()));
    }
}
