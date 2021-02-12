package com.functional.functional.imperative;

public class Capacity {
    private final String name;
    private final Integer amount;

    public Capacity(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Capacity{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
