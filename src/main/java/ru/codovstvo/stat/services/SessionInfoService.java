package ru.codovstvo.stat.services;

import org.springframework.stereotype.Service;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

import ru.codovstvo.stat.Classes.Info;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;  

@Service
public class SessionInfoService {
    
    // public void main(String reqString){

    //     JSONObject json = new JSONObject(reqString);  

    //     System.out.println("----------------------");
    //     System.out.println("session: " + json.getString("countSeccion"));
    //     System.out.println("lengthSeccion: " + json.getString("lengthSeccion"));
    //     System.out.println("----------------------");
    // }

    // public void main2(String reqString) throws ParseException{
    //     Object obj = new JSONParser().parse(reqString);
    //     JSONObject jo = (JSONObject) obj;

    //     System.out.println("----------------------");
    //     System.out.println("session: " + jo.getString("countSeccion"));
    //     System.out.println("lengthSeccion: " + jo.getString("lengthSeccion"));
    //     System.out.println("----------------------");
    // }

    public void main3(String reqString){

        Gson g = new Gson();

        Info info = g.fromJson(reqString, Info.class);

        System.out.println("----------------------");
        System.out.println("session: " + info.countSession);
        System.out.println("lengthSeccion: " + info.leghtSession);
        System.out.println("----------------------");
    }

}
