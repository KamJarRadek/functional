package com.functional.functional.predicate;

import com.functional.functional.imperative.Capacity;
import com.functional.functional.imperative.Drink;
import com.functional.functional.imperative.DrinkType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DrinkTest {
    List<Drink> drinks;

    private Predicate<Drink> isTea = drink -> drink.getDrinkType().equals(DrinkType.TEA);
    private Predicate<Drink> isSmall = drink -> drink.getCapacity().getName().equals("small");

    private IntPredicate bigDrink = amount -> amount > 200;

    private BiPredicate<Drink, DrinkType> forChildren = (drink, tea) -> drink.getDrinkType().equals(tea);

    @Test
    public void isForChildren() {
        System.out.println(forChildren.test(new Drink("green tea", DrinkType.TEA, new Capacity("small", 50)), DrinkType.TEA));

        List<Drink> drinksForChild = drinks.stream().filter(drink -> forChildren.test(drink, DrinkType.TEA)).collect(Collectors.toList());
        System.out.println(drinksForChild);
    }

    @Test
    public void checkIfTea() {

        System.out.println(bigDrink.test(350));
        System.out.println(bigDrink.test(drinks.get(2).getCapacity().getAmount()));

        List<Drink> notTea = drinks.stream().filter(isTea.negate()).collect(Collectors.toList());
        System.out.println("Not tea " + notTea);

        System.out.println("small tea");
        List<Drink> smallTeaList = drinks.stream().filter(isTea.and(isSmall)).collect(Collectors.toList());
        System.out.println(smallTeaList);

        List<Drink> teaList = drinks.stream().filter(isTea).collect(Collectors.toList());
        System.out.println(teaList);
        System.out.println(teaList.stream().count());

        System.out.println(isTea.test(new Drink("green tea", DrinkType.TEA, new Capacity("small", 50))));

    }


    @BeforeEach
    public void setUp() {
        drinks = createDrinkList();
    }

    private List<Drink> createDrinkList() {
        return Arrays.asList(
                new Drink("green tea", DrinkType.TEA, new Capacity("small", 50)),
                new Drink("espresso", DrinkType.COFFEE, new Capacity("small", 50)),
                new Drink("black tea", DrinkType.TEA, new Capacity("large", 300)),
                new Drink("red wine", DrinkType.ALCOHOLIC, new Capacity("mid", 150)),
                new Drink("cappuccino", DrinkType.COFFEE, new Capacity("large", 300)),
                new Drink("white tea", DrinkType.TEA, new Capacity("mid", 150)),
                new Drink("white wine", DrinkType.ALCOHOLIC, new Capacity("small", 50)),
                new Drink("latte", DrinkType.COFFEE, null)
        );
    }
}
