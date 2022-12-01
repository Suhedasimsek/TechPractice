package com.amazon.tests.day15_DDF;

import com.amazon.utilities.ExcelUtil;

import java.util.Arrays;

public class ExcelUtilsDemo {

    public static void main(String[] args) {

        ExcelUtil excelUtil = new ExcelUtil("src/test/resources/Book1.xlsx","Sheet1");

        System.out.println(excelUtil.rowCount());

        System.out.println(excelUtil.columnCount());

        System.out.println(excelUtil.getColumnsNames());

        System.out.println(excelUtil.getCellData(0, 0));

        System.out.println("------------------------");

        String[][] dataArrayWithoutFirstRow = excelUtil.getDataArrayWithoutFirstRow();

        System.out.println(Arrays.deepToString(dataArrayWithoutFirstRow));


    }




}
