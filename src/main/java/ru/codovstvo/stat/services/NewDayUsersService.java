package ru.codovstvo.stat.services;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.codovstvo.stat.repo.SessionInfoRepo;
import ru.codovstvo.stat.entitys.SessionInfo;

@Service
public class NewDayUsersService {

    @Autowired
    SessionInfoRepo sessionInfoRepo;
    
    public Set<LocalDate> getNumberUsers(){
        //получить данные за последние n дней
        Set<LocalDate> dates = new HashSet<LocalDate>();
        List<SessionInfo> allData = sessionInfoRepo.findAll();

        for (SessionInfo sessionInfo : allData){
            // dates.add(sessionInfo.getStartDateSession());
            dates.add(LocalDate.parse(sessionInfo.getStartDateSession().replace(".", "-")));
        }
        
        return dates;
    }

    private LocalDate parseDate(String strDate){
        String[] arr = strDate.split(".");
        String buffer = new String();
        for (String s : arr){
            if (s.length() == 1){
                buffer = buffer + "0" + s + "-";
            }
            else{
                buffer = buffer + s + "-";
            }
        }

        buffer = buffer.substring(0, buffer.length() - 1);

        System.out.println(buffer);

        return LocalDate.parse(buffer);
    }

}
