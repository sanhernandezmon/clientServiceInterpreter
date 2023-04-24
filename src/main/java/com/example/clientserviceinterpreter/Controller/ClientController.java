package com.example.clientserviceinterpreter.Controller;

import com.example.clientserviceinterpreter.Entity.Client;
import com.example.clientserviceinterpreter.Service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Autowired
    private TranslateService translateService;

    @PostMapping("/client/{EntytiId}")
    public ResponseEntity<String> exampleMethod(@RequestBody String requestBody, @PathVariable String EntytiId) {
        // pass the requestBody to your service layer
        Client client = translateService.SaveClient(EntytiId, requestBody);
        return ResponseEntity.ok("Success");
    }

}
