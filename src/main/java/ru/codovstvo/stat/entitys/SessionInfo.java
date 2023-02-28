package ru.codovstvo.stat.entitys;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Data
@Entity

public class SessionInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;    

    private String UserIdd;


    private String startDateSession;

    private String startTimeSession;

    private String endDateSession;

    private String endTimeSession;

    private String leghtSession;

    private int countSession;


    private int wastesMoney;

    private int wastesRuby;

    private int wastesEnergy;

    private int wastesFruit;

    private int wastesApple;

    private int wastesTangerine;

    private int wastesRaspberry;

    private int wastesKey;


    private int earnedExpirience;
    
    private int earnedMoney;

    private int earnedRuby;

    private int earnedEnergy;

    private int earnedFruit;

    private int earnedApple;

    private int earnedTangerine;

    private int earnedRaspberry;

    private int earnedKey;

    
    private int activeOrder;
    
    private int collectOrder;


    private int successQuest;

    private int successDailyTask;


    private String countBuyItemShopMoney;

    private String countBuyItemShopRuby;

    private String countBuyItemShopEnergy;

    private String countBuyItemShopWorker;

    private String countBuyItemShopFruit;

    private String countBuyItemShopResources;

    private String countBuyItemShopSales;

    private String countBuyItemShopOrder;

    @ElementCollection
    private List<Integer> indexBuyItemShopMoney;

    @ElementCollection
    private List<Integer> clickBuyItemShopRuby;

    @ElementCollection
    private List<Integer> indexBuyItemShopRuby;

    @ElementCollection
    private List<Integer> indexBuyItemShopEnergy;

    @ElementCollection
    private List<Integer> indexBuyItemShopWorker;

    @ElementCollection
    private List<Integer> indexBuyItemShopFruit;

    @ElementCollection
    private List<Integer> indexBuyItemShopResources;
    
    @ElementCollection
    private List<Integer> indexBuyItemShopSales;


    private int clickAD;

    private int successAD;

    private int errorAD;
    

    private int clickDonate;

    private int successDonate;

    private int redirectCount;

    @ElementCollection
    private List<String> typeClickDonate;

    @ElementCollection
    private List<Integer> timeClickDonate;

    @ElementCollection
    private List<Integer> timeSpawnClouds;

    @Column(columnDefinition="TEXT")
    private String full;

    public SessionInfo()
    {
        
    }

}
