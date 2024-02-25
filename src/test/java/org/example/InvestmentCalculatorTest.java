package org.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class InvestmentCalculatorTest extends TestCase {
    InvestmentCalculator investmentcalculator = new InvestmentCalculator(0.2);
    @Test
    public void testCalculate() {
        double principal = 10000;
        double rate = 0.05;
        int years = 10;
        double expected =Math.round(10000* Math.pow(1+0.05, 10) * (1-0.2));
        double result = investmentcalculator.calculate(principal,rate,years);
        assertEquals(expected, result, 0.001); // 0.001 is the delta for double comparison

    }
}