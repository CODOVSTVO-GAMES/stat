package ru.codovstvo.stat.services;

import org.springframework.stereotype.Service;

@Service
public class Converters {

    public String arrayToString(int[] array){
        String str = new String();

        if (array.length == 0) return "";

        for(int i = 0; i < array.length; i++){
            str = str + array[i] + "_";
        }

        return str;
    }

}
