package com.example.demo.controller;

import com.example.demo.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
}