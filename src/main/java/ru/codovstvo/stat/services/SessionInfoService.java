package ru.codovstvo.stat.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import ru.codovstvo.stat.Classes.Info;
import ru.codovstvo.stat.entitys.SessionInfo;
import ru.codovstvo.stat.repo.SessionInfoRepo;

@Service
public class SessionInfoService {

    @Autowired
    SessionInfoRepo sessionInfoRepo;

    public void main(String reqString){
        Info info = parseJsonToInfoClass(reqString);

        System.out.println("----------------------");
        System.out.println("session: " + info.countSeccion);
        System.out.println("lengthSeccion: " + info.lengthSeccion);
        System.out.println("----------------------");

        SessionInfo newSessionInfo = new SessionInfo(info);
        
        if (sessionInfoRepo.existsByUserIddAndCountSession(info.userId, info.countSeccion)) {
            SessionInfo oldSessionInfo = sessionInfoRepo.findByUserIddAndCountSession(info.userId, info.countSeccion);
            Long id = oldSessionInfo.getId();
            newSessionInfo.setId(id);
        }

        sessionInfoRepo.save(newSessionInfo);
    }

    public Info parseJsonToInfoClass(String str){
        Gson g = new Gson();
        return g.fromJson(str, Info.class);
    }

}
