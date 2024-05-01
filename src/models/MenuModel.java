package models;

import services.ApiConnector;

import java.util.Scanner;

public class MenuModel {
    public static void exibirMenu(){
        ApiConnector api = new ApiConnector();
        Scanner sc = new Scanner(System.in);

        var opcao = "";

        while (!opcao.equalsIgnoreCase("sair")){

            System.out.println("\nSeja bem vindo/a ao Conversor de Moeda =]");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileiro");
            System.out.println("4) Real brasileiro =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Sair");

            opcao = sc.next();

            switch (opcao){
                case "1":
                    System.out.print("Digite a quantidade em dólar: ");
                    double usdAmount = sc.nextDouble();
                    CurrencyData currencyData = api.getCurrency("USD");
                    double exchangeRate = currencyData.conversionRates().get("ARS");
                    double arsAmount = usdAmount * exchangeRate;
                    System.out.printf("%.2f USD equivalem a %.2f ASR%n", usdAmount, arsAmount);
                break;
            }
        }
    }
}
