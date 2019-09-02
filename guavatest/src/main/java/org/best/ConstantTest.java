package org.best;

import static org.hujianbest.Constant.MAP;

public class ConstantTest {
    public static void main(String[] args) {
        System.out.println("777");
        if (MAP.containsKey(1)){
            System.out.println("666");
        }
        if (MAP.containsKey(12)){
            System.out.println("666");
        } else {
            System.out.println("999");
        }
    }
}
