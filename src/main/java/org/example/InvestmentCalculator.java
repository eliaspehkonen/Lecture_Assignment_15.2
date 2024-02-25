package org.example;

public class InvestmentCalculator {
    private double taxRate;

    public InvestmentCalculator(double taxRate) {
        this.taxRate = taxRate;
    }

    public double calculate(double principal, double rate, int years) {
        double amount = principal * Math.pow(1 + rate, years);
        double tax = amount * taxRate;
        return Math.round(amount - tax);
    }

    public static void main(String[] args) {
        InvestmentCalculator calculator = new InvestmentCalculator(0.2); // 20% tax rate
        double principal = 10000;
        double rate = 0.05; // 5% annual interest rate
        int years = 10;
        double result = calculator.calculate(principal, rate, years);
        System.out.println("Investment after tax deduction: " + result);
    }
}
