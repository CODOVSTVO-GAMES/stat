package ru.codovstvo.stat.entitys;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Data
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;   


    private String platformUserId;

    private LocalDate registrationDate;

    private LocalDate firstReference;

    private Integer countSession;

    private Integer lengthLivetime;


    private Integer clickBank;

    private Integer clickAd;

    private Integer successAd;

    private Integer clickDonate;

    private Integer successDonate;

    private Integer countCollectCloud;

    private Integer successQuest;

    private Integer successDailyTask;

    private Integer activeOrder;

    private Integer collectOrder;

    
    private Integer earnedKey;

    private Integer earnedFruit;

    private Integer earnedEnergy;

    private Integer earnedRuby;

    private Integer earnedMoney;


    private Integer wastesKey;

    private Integer wastesFruit;

    private Integer wastesEnergy;

    private Integer wastesRuby;

    private Integer wastesMoney;


    public UserInfo(){
    }

    public UserInfo(String platformUserId){
        this.platformUserId = platformUserId;
    }

    public void findAndAddMaxCountSession(int countSession){
        if (countSession > this.countSession){
            this.countSession = countSession;
        }
    }

    public void findAndAddFirstReference(LocalDate ld){
        if (firstReference != null && firstReference.isAfter(ld)){
            firstReference = ld;
        }
    }

    public void addLivetime(int liveTime){
        lengthLivetime += liveTime;
    }

    public void addClickBank(int clickBank){
        this.clickBank += clickBank;
    }

    public void addClickAd(int clickAd){
        this.clickAd += clickAd;
    }

    public void addSuccessAd(int successAd){
        this.successAd += successAd;
    }

    public void addClickDonate(int clickDonate){
        this.clickDonate += clickDonate;
    }

    public void addSuccessDonate(int successDonate){
        this.successDonate += successDonate;
    }

    public void addCountCollectCloud(int countCollectCloud){
        this.countCollectCloud += countCollectCloud;
    }

    public void addSuccessQuest(int successQuest){
        this.successQuest += successQuest;
    }

    public void addSuccessDailyTask(int successDailyTask){
        this.successDailyTask += successDailyTask;
    }

    public void addActiveOrder(int activeOrder){
        this.activeOrder += activeOrder;
    }

    public void addCollectOrder(int collectOrder){
        this.collectOrder += collectOrder;
    }

    public void addEarnedKey(int earnedKey){
        this.earnedKey += earnedKey;
    }

    public void addEarnedFruit(int earnedFruit){
        this.earnedFruit += earnedFruit;
    }

    public void addEarnedEnergy(int earnedEnergy){
        this.earnedEnergy += earnedEnergy;
    }

    public void addEarnedRuby(int earnedRuby){
        this.earnedRuby += earnedRuby;
    }

    public void addEarnedMoney(int earnedMoney){
        this.earnedMoney += earnedMoney;
    }

    public void addWastesKey(int wastesKey){
        this.wastesKey += wastesKey;
    }

    public void addWastesFruit(int wastesFruit){
        this.wastesFruit += wastesFruit;
    }

    public void addWastesEnergy(int wastesEnergy){
        this.wastesEnergy += wastesEnergy;
    }

    public void addWastesRuby(int wastesRuby){
        this.wastesRuby += wastesRuby;
    }

    public void addWastesMoney(int wastesMoney){
        this.wastesMoney += wastesMoney;
    }

    public float getAverageLengthSession(){
        if (countSession > 0 && lengthLivetime > 0){
            float cs = countSession;
            float llt = lengthLivetime;
            return llt / cs;
        }
        else return 0;
    }
}
