package com.example.tax;

import javax.jws.WebService;


@WebService(targetNamespace = "http://localhost:2313/taxService")
public class TaxCalculator {
    public double calculateTax(double income) {
        if (income <= 5000) {
            return 0;
        } else if (income <= 10000) {
            return (income - 5000) * 0.10;
        } else if (income <= 20000) {
            return 500 + (income - 10000) * 0.20;
        } else {
            return 2500 + (income - 20000) * 0.30;
        }
    }
}