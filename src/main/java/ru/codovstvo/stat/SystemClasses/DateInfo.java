package ru.codovstvo.stat.SystemClasses;

public class DateInfo {

    public String date;
    
    public int totalNumber;

    public int VKNumber;
    
    public int OKNumber;

    public int YANumber;

    public DateInfo(String date, int totalNumber, int VKNumber, int OKNumber, int YANumber){
        this.date = date;
        this.totalNumber = totalNumber;
        this.VKNumber = VKNumber;
        this.OKNumber = OKNumber;
        this.YANumber = YANumber;
    }

}
