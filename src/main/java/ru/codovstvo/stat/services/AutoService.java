package ru.codovstvo.stat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.codovstvo.stat.repo.SessionInfoRepo;

@Transactional
@Service
public class AutoService {

    @Autowired
    SessionInfoRepo sessionInfoRepo;

    @Scheduled(initialDelay = 100, fixedDelay = 6000000)
    public void AutoAdminLogsDelete(){
        Long[] admins = new Long[] { 77517618l, 81313640l, 36733860l, 141398825l, 186475046l, 532515793l, 19346574l, 580946266481l, 586485652436l };
        System.out.println("Запущено удаление логов админов");

        for(int i = 0; i < admins.length; i++){
            sessionInfoRepo.deleteAllBylatformUserId(Long.toString(admins[i]));
        }
    }

}
