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
import ru.codovstvo.stat.SystemClasses.*;


@RestController
@RequestMapping(value = "stat/getter")
public class StatController {

    @Autowired
    NewDayUsersService newDayUsersService;
    
    @GetMapping("get")
    public List<DateInfo> get1() {
        // System.out.println(requestBody);
        return newDayUsersService.getSessionLengthInDay();
    }
    
    //Готовы --->

    @GetMapping("newusersinday")
    public List<DateInfo> getNewUsersInDay() {
        return newDayUsersService.getNewUsersInDay();
    }

    @GetMapping("usersinday")
    public List<DateInfo> getUsersInDay() {
        return newDayUsersService.getUsersInDay();
    }

}
