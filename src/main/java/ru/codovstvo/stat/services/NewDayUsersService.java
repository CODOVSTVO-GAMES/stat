package ru.codovstvo.stat.services;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.codovstvo.stat.repo.SessionInfoRepo;
import ru.codovstvo.stat.entitys.SessionInfo;

@Service
public class NewDayUsersService {

    @Autowired
    SessionInfoRepo sessionInfoRepo;

    // public Map<LocalDate, Integer> getUsersInDay(){

    // }
    
    public List<LocalDate> getDatesInfo(){

        Set<LocalDate> dates = new HashSet<LocalDate>();
        List<SessionInfo> allData = sessionInfoRepo.findAll();

        for (SessionInfo sessionInfo : allData){
            dates.add(stringToDate(sessionInfo.getStartDateSession()));
        }

        List<LocalDate> localDates = new ArrayList<LocalDate>(dates);

        List<LocalDate> sortedLocalDates = new ArrayList<LocalDate>();

        while(localDates.size() > 1){
            LocalDate bufferDate = localDates.get(0);
            for (int i = 1; i < localDates.size(); i++){
                if (bufferDate.isAfter(localDates.get(i))) {
                    bufferDate = localDates.get(i);
                }
            }
            sortedLocalDates.add(bufferDate);
            localDates.remove(bufferDate);
        }
        sortedLocalDates.add(localDates.get(0));

        dateToString(localDates.get(0));

        return sortedLocalDates;
    }

    private LocalDate stringToDate(String strDate){
        String[] arr = strDate.split("\\.");

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return LocalDate.parse(buffer, formatter);
    }

    private String dateToString(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println(date.format(formatter));
        return date.format(formatter);
    }

}
