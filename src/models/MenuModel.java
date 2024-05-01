package models;

import services.ApiConnector;

import java.util.Scanner;

public class MenuModel {
    public static void exibirMenu(){
        ApiConnector api = new ApiConnector();
        Scanner sc = new Scanner(System.in);

        var opcao = "";

        while (!opcao.equalsIgnoreCase("sair")){
            try {
                System.out.println("*****************************************************");
                System.out.println("\nSeja bem vindo/a ao Conversor de Moeda =]");
                System.out.println("1) Dólar =>> Peso argentino");
                System.out.println("2) Peso argentino =>> Dólar");
                System.out.println("3) Dólar =>> Real brasileiro");
                System.out.println("4) Real brasileiro =>> Dólar");
                System.out.println("5) Dólar =>> Peso colombiano");
                System.out.println("6) Peso colombiano =>> Dólar");
                System.out.println("7) Sair");

                System.out.println("Escola a opção válida: ");
                System.out.println("*****************************************************");
                opcao = sc.next();

                if (!opcao.matches("[1-7]")){
                    throw new IllegalArgumentException("Opção inválida. Escolha uma opção de 1 a 7.");
                }

                switch (opcao) {
                    case "1":
                        System.out.print("Digite a quantidade em dólar: ");
                        sc.nextLine();
                        double usdAmount = sc.nextDouble();
                        CurrencyData currencyData = api.getCurrency("USD");
                        double exchangeRate = currencyData.conversionRates().get("ARS");
                        double arsAmount = usdAmount * exchangeRate;
                        System.out.printf("%.2f USD equivalem a %.2f ASR%n", usdAmount, arsAmount);
                        break;
                    case "2":
                        System.out.print("Digite a quantidade em Peso argentino: ");
                        arsAmount = sc.nextDouble();
                        currencyData = api.getCurrency("ARS");
                        exchangeRate = currencyData.conversionRates().get("USD");
                        usdAmount = arsAmount * exchangeRate;
                        System.out.printf("%.2f ARS equivalem a %.2f USD%n", arsAmount, usdAmount);
                        break;
                    case "3":
                        System.out.print("Digite a quantidade em Dolar: ");
                        usdAmount = sc.nextDouble();
                        currencyData = api.getCurrency("USD");
                        exchangeRate = currencyData.conversionRates().get("BRL");
                        double brlAmount = usdAmount * exchangeRate;
                        System.out.printf("%.2f USD equivalem a %.2f BRL%n", usdAmount, brlAmount);
                        break;
                    case "4":
                        System.out.print("Digite a quantidade em Real: ");
                        brlAmount = sc.nextDouble();
                        currencyData = api.getCurrency("BRL");
                        exchangeRate = currencyData.conversionRates().get("USD");
                        usdAmount = brlAmount * exchangeRate;
                        System.out.printf("%.2f BRL equivalem a %.2f USD%n", brlAmount, usdAmount);
                        break;
                    case "5":
                        System.out.print("Digite a quantidade em dólar: ");
                        usdAmount = sc.nextDouble();
                        currencyData = api.getCurrency("USD");
                        exchangeRate = currencyData.conversionRates().get("COP");
                        double copAmount = usdAmount * exchangeRate;
                        System.out.printf("%.2f USD equivalem a %.2f COP%n", usdAmount, copAmount);
                        break;
                    case "6":
                        System.out.print("Digite a quantidade em dólar: ");
                        copAmount = sc.nextDouble();
                        currencyData = api.getCurrency("COP");
                        exchangeRate = currencyData.conversionRates().get("USD");
                        usdAmount = copAmount * exchangeRate;
                        System.out.printf("%.2f COP equivalem a %.2f USD%n", copAmount, usdAmount);
                        break;
                    default:
                        break;
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
