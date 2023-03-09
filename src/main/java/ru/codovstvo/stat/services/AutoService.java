package ru.codovstvo.stat.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.codovstvo.stat.repo.SessionInfoRepo;
import ru.codovstvo.stat.repo.UserInfoRepo;
import ru.codovstvo.stat.entitys.SessionInfo;
import ru.codovstvo.stat.entitys.UserInfo;

@Transactional
@Service
public class AutoService {

    @Autowired
    SessionInfoRepo sessionInfoRepo;

    @Autowired
    UserInfoRepo userInfoRepo;

    @Autowired
    NewDayUsersService newDayUsersService;

    @Scheduled(initialDelay = 100, fixedDelay = 6000000)
    public void AutoAdminLogsDelete(){
        Long[] admins = new Long[] { 77517618l, 81313640l, 36733860l, 141398825l, 186475046l, 532515793l, 19346574l, 580946266481l, 586485652436l };
        System.out.println("Запущено удаление логов админов");

        for(int i = 0; i < admins.length; i++){
            sessionInfoRepo.deleteAllByPlatformUserId(Long.toString(admins[i]));
        }
    }

    @Scheduled(initialDelay = 600, fixedDelay = 6000000)
    public void AutoCounter(){
        System.out.println("Запущено заполнение пользователей");
        List<SessionInfo> sessions = sessionInfoRepo.findAll();

        List<UserInfo> uniqUsers = findUniqueUsers(sessions);

        for (UserInfo user : uniqUsers){
            userInfoRepo.save(fillUser(user));
        }
    }

    private List<UserInfo> findUniqueUsers(List<SessionInfo> sessions){
        Set<String> users = new HashSet<String>();

        for (SessionInfo s : sessions){
            if (!users.contains(s.getPlatformUserId())){
                users.add(s.getPlatformUserId());
            }else{}
        }

        
        List<UserInfo> usersInfo = new ArrayList<UserInfo>();

        for (String s : users){
            usersInfo.add(new UserInfo(s));
        }

        return usersInfo;
    }

    private UserInfo fillUser(UserInfo user){
        List<SessionInfo> sessions = sessionInfoRepo.findAllByPlatformUserId(user.getPlatformUserId());

        for(SessionInfo s : sessions){
            user.findAndAddMaxCountSession(s.getCountSession());
            user.addLivetime(Integer.parseInt(s.getLeghtSession()));
            user.findAndAddFirstReference(newDayUsersService.stringToDate(s.getStartDateSession()));

            user.addClickBank(s.getClickBank());
            user.addClickAd(s.getClickAD());
            user.addSuccessAd(s.getSuccessAD());
            user.addClickDonate(s.getClickDonate());
            user.addSuccessDonate(s.getSuccessDonate());
            user.addCountCollectCloud(s.getCountCollectCloud());
            user.addSuccessQuest(s.getSuccessQuest());
            user.addSuccessDailyTask(s.getSuccessDailyTask());
            user.addActiveOrder(s.getActiveOrder());
            user.addCollectOrder(s.getCollectOrder());
            user.addEarnedKey(s.getEarnedKey());
            user.addEarnedFruit(s.getEarnedFruit());
            user.addEarnedEnergy(s.getEarnedEnergy());
            user.addEarnedRuby(s.getEarnedRuby());
            user.addEarnedMoney(s.getEarnedMoney());
            user.addWastesKey(s.getWastesKey());
            user.addWastesFruit(s.getWastesFruit());
            user.addWastesEnergy(s.getWastesEnergy());
            user.addWastesRuby(s.getWastesRuby());
            user.addWastesMoney(s.getWastesMoney());

            if (s.getCountSession() == 1){
                user.setRegistrationDate(newDayUsersService.stringToDate(s.getStartDateSession()));
            }
        }

        return user;
    }

    private List<SessionInfo> getSessionUser(UserInfo user){
        return sessionInfoRepo.findAllByPlatformUserId(user.getPlatformUserId());
    }

    private Set<String> getUniqueUsers(List<SessionInfo> array){
        Set<String> users = new HashSet<String>();

        for (SessionInfo s : array){
            if (!users.contains(s.getPlatformUserId())){
                users.add(s.getPlatformUserId());
            }else{}
        }
        return users;
    }  

}
