package com.example.demo.controller;

import com.example.demo.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @PostMapping
    public ResponseEntity<Map<Integer, Long>> getSimpleNumbers(@RequestBody List<Integer> list) {
        Map<Integer, Long> integerLongMap = mainService.getSimpleNumbers(list);
        return ResponseEntity.ok(integerLongMap);
    }

    @GetMapping
    public ResponseEntity<String> getHi(@RequestParam String name) {
        return new ResponseEntity<>("Hello, " + name, HttpStatus.OK);
    }
}