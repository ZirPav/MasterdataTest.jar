package com.example.demo.service.impl;

import com.example.demo.service.MainService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MainServiceImpl implements MainService {

    @Override
    public Map<Integer, Long> getSimpleNumbers(List<Integer> list) {
        return list.stream()
                .filter(MainServiceImpl::checkSimple)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static boolean checkSimple(Integer integer) {
        integer = Math.abs(integer);
        for (int i = 2; i <= Math.sqrt(integer); i++) {
            if (integer % i == 0) {
                return false;
            }
        }
        return true;
    }
}