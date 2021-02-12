package com.functional.functional.imperative;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

class DrinkTest {

    List<Drink> drinks;

    @Test
    public void imperative() {
        List<Drink> coffeeList = new ArrayList<>();
        for (Drink drink : drinks) {
            if (drink.getDrinkType().equals(DrinkType.COFFEE)) {
                coffeeList.add(drink);
                System.out.println(drink);
            }
        }
        int amountOfCoffeeDrinks = 0;
        for (Drink drink : coffeeList) {
            if (drink.getCapacity() != null) {
                amountOfCoffeeDrinks = drink.getCapacity().getAmount();
            }
        }
        System.out.println("sum of amount: " + amountOfCoffeeDrinks);
    }


    @Test
    public void declarative() {
        System.out.println("declarative");
        System.out.println(drinks.stream().filter(checkIfCoffee).map(Drink::getCapacity)
                .filter(Objects::nonNull)
                .mapToInt(Capacity::getAmount).sum());
    }

    private Predicate<Drink> checkIfCoffee = drink -> drink.getDrinkType().equals(DrinkType.COFFEE);

    @BeforeEach
    public void setUp() {
        drinks = createDrinkList();
    }

    private List<Drink> createDrinkList() {
        return Arrays.asList(
                new Drink("green tea", DrinkType.TEA, new Capacity("small", 50)),
                new Drink("espresso", DrinkType.COFFEE, new Capacity("small", 50)),
                new Drink("black tea", DrinkType.TEA, new Capacity("large", 300)),
                new Drink("red wine", DrinkType.ALCOHOLIC, new Capacity("min", 150)),
                new Drink("cappuccino", DrinkType.COFFEE, new Capacity("large", 300)),
                new Drink("white tea", DrinkType.TEA, new Capacity("mid", 150)),
                new Drink("white wine", DrinkType.ALCOHOLIC, new Capacity("small", 50)),
                new Drink("latte", DrinkType.COFFEE, null)
        );
    }
}