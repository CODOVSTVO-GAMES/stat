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

    private String device;//


    private String startDateSession;

    private String startTimeSession;

    private String endDateSession;

    private String endTimeSession;

    private String leghtSession;

    private Integer countSession;

    @Column(columnDefinition="TEXT")
    private String mergeCountItems;//

    private Integer clickBank;//


    private Integer wastesMoney;

    private Integer wastesRuby;

    private Integer wastesEnergy;

    private Integer wastesFruit;

    private Integer wastesApple;

    private Integer wastesTangerine;

    private Integer wastesRaspberry;

    private Integer wastesKey;


    private Integer earnedExpirience;
    
    private Integer earnedMoney;

    private Integer earnedRuby;

    private Integer earnedEnergy;

    private Integer earnedFruit;

    private Integer earnedApple;

    private Integer earnedTangerine;

    private Integer earnedRaspberry;

    private Integer earnedKey;

    
    private Integer activeOrder;
    
    private Integer collectOrder;


    private Integer successQuest;

    private Integer successDailyTask;


    private Integer countBuyItemShopMoney;

    private Integer countBuyItemShopRuby;

    private Integer countBuyItemShopEnergy;

    private Integer countBuyItemShopWorker;

    private Integer countBuyItemShopFruit;

    private Integer countBuyItemShopResources;

    private Integer countBuyItemShopSales;

    private Integer countBuyItemShopOrder;
    

    private String indexBuyItemShopMoney;

    private String clickBuyItemShopRuby;

    private String indexBuyItemShopRuby;

    private String indexBuyItemShopEnergy;

    private String indexBuyItemShopWorker;

    private String indexBuyItemShopFruit;

    private String indexBuyItemShopResources;
    
    private String indexBuyItemShopSales;


    private Integer clickAD;

    private Integer successAD;

    private Integer errorAD;
    

    private Integer clickDonate;

    private Integer successDonate;

    private Integer redirectCount;

    private String typeClickDonate;

    private String timeClickDonate;

    private String timeSpawnClouds;//???????????????? ???? timeSpawnCloudsText

    private Integer countCollectCloud;


    @Column(columnDefinition="TEXT")
    private String timeSpawnCloudsText;

    @Column(columnDefinition="TEXT")
    private String countSpawnCloudText;


    public SessionInfo(){}


    public SessionInfo(Info info)
    {
        this.platformUserId = info.userId;
        this.platform = info.platform;
        this.device = info.device;
        this.startDateSession = info.startDataSession;
        this.startTimeSession = info.startTimeSession;
        this.endDateSession = info.endDataSession;
        this.endTimeSession = info.endTimeSession;
        this.leghtSession = info.lengthSeccion;
        this.countSession = info.countSeccion;

        this.mergeCountItems = intArrayToString(info.mergeCountItems);
        this.clickBank = info.clickBank;

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
        this.timeSpawnCloudsText = intArrayToString(info.timeSpawnClouds);

        this.countCollectCloud = info.countCollectCloud;
        this.countSpawnCloudText = intArrayToString(info.countSpawnCloudText);
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
