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

    public void findAndAddMaxCountSession(Integer countSession){

        if (countSession > this.countSession && countSession != null){
            this.countSession = countSession;
        }
    }

    public void findAndAddFirstReference(LocalDate ld){
        if (firstReference != null && firstReference.isAfter(ld)){
            firstReference = ld;
        }
    }

    public void addLivetime(Integer liveTime){
        if (liveTime != null){
            lengthLivetime += liveTime;
        }
    }

    public void addClickBank(Integer clickBank){
        if (clickBank != null){
            this.clickBank += clickBank;
        }
    }

    public void addClickAd(Integer clickAd){
        if (clickAd != null){
            this.clickAd += clickAd;
        }
    }

    public void addSuccessAd(Integer successAd){
        if (successAd != null){
            this.successAd += successAd;
        }
    }

    public void addClickDonate(Integer clickDonate){
        if (clickDonate != null){
            this.clickDonate += clickDonate;
        }
    }

    public void addSuccessDonate(Integer successDonate){
        if (successDonate != null){
            this.successDonate += successDonate;
        }
    }

    public void addCountCollectCloud(Integer countCollectCloud){
        if (countCollectCloud != null){
            this.countCollectCloud += countCollectCloud;
        }
    }

    public void addSuccessQuest(Integer successQuest){
        if (successQuest != null){
            this.successQuest += successQuest;
        }
    }

    public void addSuccessDailyTask(Integer successDailyTask){
        if (successDailyTask != null){
            this.successDailyTask += successDailyTask;
        }
    }

    public void addActiveOrder(Integer activeOrder){
        if (activeOrder != null){
            this.activeOrder += activeOrder;
        }
    }

    public void addCollectOrder(Integer collectOrder){
        if (collectOrder != null){
            this.collectOrder += collectOrder;
        }
    }

    public void addEarnedKey(Integer earnedKey){
        if (earnedKey != null){
            this.earnedKey += earnedKey;
        }
    }

    public void addEarnedFruit(Integer earnedFruit){
        if (earnedFruit != null){
            this.earnedFruit += earnedFruit;
        }
    }

    public void addEarnedEnergy(Integer earnedEnergy){
        if (earnedEnergy != null){
            this.earnedEnergy += earnedEnergy;
        }
    }

    public void addEarnedRuby(Integer earnedRuby){
        if (earnedRuby != null){
            this.earnedRuby += earnedRuby;
        }
    }

    public void addEarnedMoney(Integer earnedMoney){
        if (earnedMoney != null){
            this.earnedMoney += earnedMoney;
        }
    }

    public void addWastesKey(Integer wastesKey){
        if (wastesKey != null){
            this.wastesKey += wastesKey;
        }
    }

    public void addWastesFruit(Integer wastesFruit){
        if (wastesFruit != null){
            this.wastesFruit += wastesFruit;
        }
    }

    public void addWastesEnergy(Integer wastesEnergy){
        if (wastesEnergy != null){
            this.wastesEnergy += wastesEnergy;
        }
    }

    public void addWastesRuby(Integer wastesRuby){
        if (wastesRuby != null){
            this.wastesRuby += wastesRuby;
        }
    }

    public void addWastesMoney(Integer wastesMoney){
        if (wastesMoney != null){
            this.wastesMoney += wastesMoney;
        }
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
