package com.sansan.java8.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(new Apple("green", 150), new Apple("red", 180), new Apple("green", 130));
        //匿名内部类写法
        List<Apple> retAppleList1 = findApples(appleList, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return "green".equals(apple.getColor());
            }
        });

        //lambda表达式写法
        List<Apple> retAppleList2 = findApples(appleList, apple -> "red".equals(apple.getColor()));

        System.out.println(retAppleList1.toString());
        System.out.println(retAppleList2.toString());
    }

    private static List<Apple> findApples(List<Apple> appleList, AppleFilter appleFilter) {
        List<Apple> retList = new ArrayList<>();
        for (Apple apple : appleList) {
            if (appleFilter.filter(apple)) {
                retList.add(apple);
            }
        }

        return retList;
    }
}
