package com.example.tax;

import javax.xml.ws.Endpoint;

public class TaxServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:2313/taxService", new TaxCalculator());
        System.out.println("Tax Service is published at http://localhost:2313/taxService");
    }
}