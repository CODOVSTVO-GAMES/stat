package ru.codovstvo.stat.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import ru.codovstvo.stat.services.NewDayUsersService;


@RestController
@RequestMapping(value = "stat/getter")
public class StatController {

    @Autowired
    NewDayUsersService newDayUsersService;
    
    @GetMapping("get")
    public List<LocalDate> get1() {
        // System.out.println(requestBody);
        return newDayUsersService.getDatesInfo();
    }
    
}
