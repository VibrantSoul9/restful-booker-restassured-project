package com.restful.booker.utils;/**
 * @author VibrantSoul
 */

import java.util.Random;

/**
 *@author VibrantSoul
 */
public class TestUtils {
    public static String getRandomValue(){
        Random random = new Random();
        int randomInt = random.nextInt(10000);
        return Integer.toString(randomInt);
    }
}
