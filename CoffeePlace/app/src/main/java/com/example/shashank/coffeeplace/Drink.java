package com.example.shashank.coffeeplace;

/**
 * Created by Shashank on 12-02-2018.
 */

public class Drink {

    private String name;
    private String decription;
    private int imageResourceId;

    public static final Drink[] drinks = {
            new Drink("Latte", "A couple of espresso shots with steamed milk", R.drawable.latte),
            new Drink("Cappuccino", "Espresso, hot milk, and a steamed milk foam", R.drawable.cappuccino),
            new Drink("Filter", "Highest quality beans roasted and brewed fresh", R.drawable.filter)
    };

    private Drink(String name, String description, int imageResourceId){
        this.name = name;
        this.decription = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName(){
        return name;
    }

    public String getDecription(){
        return decription;
    }

    public int getImageResourceId(){
        return imageResourceId;
    }

    public String toString(){
        return this.name;
    }
}
