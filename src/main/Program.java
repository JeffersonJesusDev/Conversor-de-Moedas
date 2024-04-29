package main;

import services.ApiConnector;
import models.CurrencyData;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        ApiConnector api = new ApiConnector();
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a quantidade em dólar: ");
        double usdAmount = sc.nextDouble();

        CurrencyData currencyData = api.getCurrency("USD");
        double exchangeRate = currencyData.conversionRates().get("BRL");
        double brlAmount = usdAmount * exchangeRate;

        System.out.printf("%.2f USD equivalem a %.2f BRL%n", usdAmount, brlAmount);
    }
}
