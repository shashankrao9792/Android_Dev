package com.example.shashank.beeradvisor;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shashank on 11-02-2018.
 */

public class BeerExpert {
    public List<String> getBrands(String beerType){
        List<String> beerList = new ArrayList<>();
        if(beerType.equals("amber")){
            beerList.add("Jack Amber");
            beerList.add("Red Moose");
        }
        else if(beerType.equals("light")){
            beerList.add("Jail Pale Ale");
            beerList.add("Gout Stout");
        }
        else if(beerType.equals("brown")){
            beerList.add("Brown water");
            beerList.add("Muddy drink");
        }
        else if(beerType.equals("dark")){
            beerList.add("Black cat");
            beerList.add("Donny darko");
        }
        return beerList;
    }
}
