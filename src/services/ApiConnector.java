package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import models.CurrencyData;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ApiConnector {

    public CurrencyData getCurrency(String base) {

        try {
            //Configuração API
            URI endpoint = URI.create("https://v6.exchangerate-api.com/v6/6e50520f638ddc9f920f5673/latest/" + base);
            //Fazendo requisição
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(endpoint)
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            //Conversão para Json
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
            JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");
            Map<String, Double> conversionRates = gson.fromJson(rates, Map.class);

            return new CurrencyData(base, conversionRates);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não conseguiu obter os dados da API");
        }
    }
}
