package ru.codovstvo.stat.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.codovstvo.stat.repo.SessionInfoRepo;

@Service
public class NewDayUsersService {

    @Autowired
    SessionInfoRepo sessionInfoRepo;
    
    public Set<String> getNumberUsers(){
        //получить данные за последние n дней
        return sessionInfoRepo.findAllStartDateSessionDistinct();
    }
}
