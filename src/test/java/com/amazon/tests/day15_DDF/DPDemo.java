package com.amazon.tests.day15_DDF;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DPDemo {

    public static void main(String[] args) {

        String[] name = {"Talip", "İhsan", "Mustafa"};
        String[][] name1 = {{"Talip","İhsan","Mustafa"}, {"İbrahim","Zafer", "Cengiz"}};


    }

    @DataProvider
    public Object[][] testData(){

        String[][] data = {{"Person Of Interest", "9"}, {"Fringe", "8"}, {"Dark", "9"}};

        return data;

    }

    @Test(dataProvider = "testData")
    public void test1(String tvshow, String rating){

        System.out.println("Tv show " + tvshow + " has rating " + rating);

    }



}
