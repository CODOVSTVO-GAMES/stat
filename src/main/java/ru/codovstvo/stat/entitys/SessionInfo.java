package ru.codovstvo.stat.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;
import ru.codovstvo.stat.Classes.Info;

@Data
@Entity
public class SessionInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;    

    private String platformUserId;

    private String platform;


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


    private int countBuyItemShopMoney;

    private int countBuyItemShopRuby;

    private int countBuyItemShopEnergy;

    private int countBuyItemShopWorker;

    private int countBuyItemShopFruit;

    private int countBuyItemShopResources;

    private int countBuyItemShopSales;

    private int countBuyItemShopOrder;
    

    private String indexBuyItemShopMoney;

    private String clickBuyItemShopRuby;

    private String indexBuyItemShopRuby;

    private String indexBuyItemShopEnergy;

    private String indexBuyItemShopWorker;

    private String indexBuyItemShopFruit;

    private String indexBuyItemShopResources;
    
    private String indexBuyItemShopSales;


    private int clickAD;

    private int successAD;

    private int errorAD;
    

    private int clickDonate;

    private int successDonate;

    private int redirectCount;

    private String typeClickDonate;

    private String timeClickDonate;

    private String timeSpawnClouds;

    public SessionInfo(){}


    public SessionInfo(Info info)
    {
        this.platformUserId = info.userId;
        this.startDateSession = info.startDataSession;
        this.startTimeSession = info.startTimeSession;
        this.endDateSession = info.endDataSession;
        this.endTimeSession = info.endTimeSession;
        this.leghtSession = info.lengthSeccion;
        this.countSession = info.countSeccion;

        this.wastesMoney = info.wastesMoney;
        this.wastesRuby = info.wastesRuby;
        this.wastesEnergy = info.wastesEnergy;
        this.wastesFruit = info.wastesFruit;
        this.wastesApple = info.wastesApple;
        this.wastesTangerine = info.wastesTangerine;
        this.wastesRaspberry = info.wastesRaspberry;
        this.wastesKey = info.wastesKey;

        this.earnedExpirience = info.earnedExpirience;
        this.earnedMoney = info.earnedMoney;
        this.earnedRuby = info.earnedRuby;
        this.earnedEnergy = info.earnedEnergy;
        this.earnedFruit = info.earnedFruit;
        this.earnedApple = info.earnedApple;
        this.earnedTangerine = info.earnedTangerine;
        this.earnedRaspberry = info.earnedRaspberry;
        this.earnedKey = info.earnedKey;

        this.activeOrder = info.activeOrder;
        this.collectOrder = info.collectOrder;

        this.successQuest = info.successQuest;
        this.successDailyTask = info.successDailyTask;

        this.countBuyItemShopMoney = info.countBuyItemShopMoney;
        this.countBuyItemShopRuby = info.countBuyItemShopRuby;
        this.countBuyItemShopEnergy = info.countBuyItemShopEnergy;
        this.countBuyItemShopWorker = info.countBuyItemShopWorker;
        this.countBuyItemShopFruit = info.countBuyItemShopFruit;
        this.countBuyItemShopResources = info.countBuyItemShopResources;
        this.countBuyItemShopSales = info.countBuyItemShopSales;
        this.countBuyItemShopOrder = info.countBuyItemShopOrder;

        this.indexBuyItemShopMoney = intArrayToString(info.indexBuyItemShopMoney);
        this.clickBuyItemShopRuby = intArrayToString(info.clickBuyItemShopRuby);
        this.indexBuyItemShopRuby = intArrayToString(info.indexBuyItemShopRuby);
        this.indexBuyItemShopEnergy = intArrayToString(info.indexBuyItemShopEnergy);
        this.indexBuyItemShopWorker = intArrayToString(info.indexBuyItemShopWorker);
        this.indexBuyItemShopFruit = intArrayToString(info.indexBuyItemShopFruit);
        this.indexBuyItemShopResources = intArrayToString(info.indexBuyItemShopResources);
        this.indexBuyItemShopSales = intArrayToString(info.indexBuyItemShopSales);
        
        this.clickAD = info.clickAD;
        this.successAD = info.successAD;
        this.errorAD = info.errorAD;
        
        this.clickDonate = info.clickDonate;
        this.successDonate = info.successDonate;
        this.redirectCount = info.redirectCount;

        this.typeClickDonate = stringArrayToString(info.typeClickDonate);
        this.timeClickDonate = intArrayToString(info.timeClickDonate);
        this.timeSpawnClouds = intArrayToString(info.timeSpawnClouds);
    }

    public String intArrayToString(int[] array){
        String str = new String();

        if (array.length == 0) return "";

        for(int i = 0; i < array.length; i++){
            str = str + array[i] + "-";
        }

        return str;
    }

    public String stringArrayToString(String[] array){
        String str = new String();

        if (array.length == 0) return "";

        for(int i = 0; i < array.length; i++){
            str = str + array[i] + "-";
        }

        return str;
    }

}
