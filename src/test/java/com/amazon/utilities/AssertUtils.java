package com.amazon.utilities;

import com.amazon.Logger.Log;
import org.testng.Assert;

public class AssertUtils {

    public static void assertEquals(Object actual, Object expected) {
        if (actual.equals(expected)) {
            Log.info(actual + " is equal to " + expected);
            Assert.assertEquals(actual, expected);
            return;
        }
        Log.info(actual + " is not equal to " + expected);
        Assert.assertEquals(actual, expected);
    }

    public static void assertTrue(boolean bool) {
        if (bool) {
            Log.info(bool + " is true");
            Assert.assertTrue(bool);
            return;
        }
        Log.info(bool + " is not true as expected");
        Assert.assertTrue(bool);
    }

    public static void assertContains(Object actual, Object expected){
        try {
            Assert.assertTrue(String.valueOf(actual).contains(String.valueOf(expected)));
            Log.info("response body contains " + expected + " as expected");

        }catch (AssertionError e){
            Log.info(actual + " does not contain " + expected);
            e.printStackTrace();
        }
    }
}