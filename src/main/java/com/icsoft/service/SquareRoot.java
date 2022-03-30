package com.icsoft.service;

import org.apache.flink.api.common.functions.MapFunction;
import org.springframework.stereotype.Service;

@Service
public class SquareRoot implements MapFunction<String, String> {

    @Override
    public String map(String num) {
        try {
            double n = Double.parseDouble(num);
            double result = Math.sqrt(n);

            return "Square root of " + num + ": " + result;

        } catch (Exception ex) {

            return "Invalid entry, input was not a numeric value.";

        }
    }
}