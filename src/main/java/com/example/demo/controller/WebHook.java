package com.example.demo.controller;

import com.example.demo.model.Envelope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebHook {

    @RequestMapping(value = "/webhook", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Envelope<Object>> getHook(@RequestBody Envelope<Object> envelope) {
        System.out.println("//*******************************************************************//");
        System.out.println("New Request: ");
        System.out.println("Event: " + envelope.getEvent());
        System.out.println("Client ID: " + envelope.getClientId());
        System.out.println("Player: " + envelope.getMessage());
        System.out.println("//*******************************************************************//");
        return ResponseEntity.ok(envelope);
    }
}
