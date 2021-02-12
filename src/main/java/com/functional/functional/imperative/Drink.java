package com.functional.functional.imperative;

public class Drink {
    private final String name;
    private final DrinkType drinkType;
    private final Capacity capacity;

    public Drink(String name, DrinkType drinkType, Capacity capacity) {
        this.name = name;
        this.drinkType = drinkType;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", drinkType=" + drinkType +
                ", capacity=" + capacity +
                '}';
    }
}
