package ru.codovstvo.stat.services;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.codovstvo.stat.repo.SessionInfoRepo;
import ru.codovstvo.stat.entitys.SessionInfo;

@Service
public class NewDayUsersService {

    @Autowired
    SessionInfoRepo sessionInfoRepo;
    
    public Set<String> getNumberUsers(){
        //получить данные за последние n дней
        Set<String> dates = new HashSet<String>();
        List<SessionInfo> allData = sessionInfoRepo.findAll();

        for (SessionInfo sessionInfo : allData){
            dates.add(sessionInfo.getStartDateSession());
        }
        
        return dates;
    }
}
