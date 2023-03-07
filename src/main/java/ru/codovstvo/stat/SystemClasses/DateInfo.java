package ru.codovstvo.stat.SystemClasses;

public class DateInfo {

    public String date;
    
    public float totalNumber;

    public float VKNumber;
    
    public float OKNumber;

    public float YANumber;

    public DateInfo(String date, float totalNumber, float VKNumber, float OKNumber, float YANumber){
        this.date = date;
        this.totalNumber = totalNumber;
        this.VKNumber = VKNumber;
        this.OKNumber = OKNumber;
        this.YANumber = YANumber;
    }

}
