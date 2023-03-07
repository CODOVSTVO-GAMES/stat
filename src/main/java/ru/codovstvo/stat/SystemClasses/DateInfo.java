package ru.codovstvo.stat.SystemClasses;

public class DateInfo {

    public String date;
    
    public long totalNumber;

    public long VKNumber;
    
    public long OKNumber;

    public long YANumber;

    public DateInfo(String date, long totalNumber, long VKNumber, long OKNumber, long YANumber){
        this.date = date;
        this.totalNumber = totalNumber;
        this.VKNumber = VKNumber;
        this.OKNumber = OKNumber;
        this.YANumber = YANumber;
    }

}
