package com.fundoopush.util;

import com.fundoopush.models.Employee;
import com.google.gson.Gson;

public class Demo {
    public static void main(String[] args) {
        Gson jsonArray = Utility.readingJsonFileFromGivenPath("./src/main/resources/TestData/emp.json");



        Employee[] employees = new Gson().fromJson(String.valueOf(jsonArray), Employee[].class);
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }


    }
}
