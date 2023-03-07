package ru.codovstvo.stat.services;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.codovstvo.stat.repo.SessionInfoRepo;
import ru.codovstvo.stat.entitys.SessionInfo;

import ru.codovstvo.stat.SystemClasses.*;

@Service
public class NewDayUsersService {

    @Autowired
    SessionInfoRepo sessionInfoRepo;

    public List<DateInfo> getSessionLengthInDay(){
        List<LocalDate> dates = getDatesInfo();

        List<DateInfo> dateInfoArray = new ArrayList<DateInfo>();

        for (LocalDate d : dates){
            List<SessionInfo> sessions = sessionInfoRepo.findAllByStartDateSession(dateToString(d));

            //получить среднюю длинну по платформам
            dateInfoArray.add(new DateInfo(dateToString(d),
                                            lengthAverageSession(sessions),
                                            lengthAverageSession(getVKSessionInfo(sessions)),
                                            lengthAverageSession(getOKSessionInfo(sessions)),
                                            lengthAverageSession(getYASessionInfo(sessions))
                                            ));
        }

        return dateInfoArray;
    }

    private long lengthAverageSession(List<SessionInfo> array){
        if(array.size() == 0) return 0;
        long sessionLength = 0l;

        for (SessionInfo s : array ){
            sessionLength =+ Long.parseLong(s.getLeghtSession());
        }

        return sessionLength / array.size();
    }

    // private Set<String> getUniqueUsers(List<SessionInfo> array){
    //     Set<String> users = new HashSet<String>();
    //     for (SessionInfo s : array){
    //         if (!users.contains(s.getPlatformUserId())){
    //             users.add(s.getPlatformUserId());
    //         }else{}
    //     }
    //     return users;
    // }    

    public List<DateInfo> getNewUsersInDay(){
        List<LocalDate> dates = getDatesInfo();

        List<DateInfo> dateInfoArray = new ArrayList<DateInfo>();
        for (LocalDate d : dates){
            String date = dateToString(d);

            List<SessionInfo> sessions = sessionInfoRepo.findAllByStartDateSessionAndCountSession(date, 1);            

            dateInfoArray.add(new DateInfo(date,
                                            sessions.size(),
                                            getVKSessionInfo(sessions).size(),
                                            getOKSessionInfo(sessions).size(),
                                            getYASessionInfo(sessions).size()
                                            ));
        }

        return dateInfoArray;
    }

    public List<DateInfo> getUsersInDay(){
        List<LocalDate> dates = getDatesInfo();

        List<DateInfo> dateInfoArray = new ArrayList<DateInfo>();
        for (LocalDate d : dates){
            String date = dateToString(d);

            List<SessionInfo> sessions = clearDublicateUsers(sessionInfoRepo.findAllByStartDateSession(date));
            
            dateInfoArray.add(new DateInfo(date,
                                            sessions.size(),
                                            getVKSessionInfo(sessions).size(),
                                            getOKSessionInfo(sessions).size(),
                                            getYASessionInfo(sessions).size()
                                            ));
        }

        return dateInfoArray;
    }

    private List<SessionInfo> clearDublicateUsers(List<SessionInfo> array){
        Set<String> users = new HashSet<String>();
        List<SessionInfo> pureSessions = new ArrayList<SessionInfo>();

        for (SessionInfo s : array){
            if (!users.contains(s.getPlatformUserId())){
                users.add(s.getPlatformUserId());
                pureSessions.add(s);
            }else{}
        }
        return pureSessions;
    }
    
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        return date.format(formatter);
    }

    private List<SessionInfo> getVKSessionInfo(List<SessionInfo> array){
        List<SessionInfo> platformArray = new ArrayList<SessionInfo>();
        for (SessionInfo s : array){
            if(s.getPlatformUserId().length() < 10){
                platformArray.add(s);
            }
        }
        return platformArray;
    }

    private List<SessionInfo> getOKSessionInfo(List<SessionInfo> array){
        List<SessionInfo> platformArray = new ArrayList<SessionInfo>();
        for (SessionInfo s : array){
            if(s.getPlatformUserId().length() > 10 && s.getPlatformUserId().length() < 14){
                platformArray.add(s);
            }
        }
        return platformArray;
    }

    private List<SessionInfo> getYASessionInfo(List<SessionInfo> array){
        List<SessionInfo> platformArray = new ArrayList<SessionInfo>();
        for (SessionInfo s : array){
            if(s.getPlatformUserId().length() > 14){
                platformArray.add(s);
            }
        }
        return platformArray;
    }

}
