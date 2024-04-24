package org.alurachallenge.converter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverterClient {
    private final String BASE_URL = "https://v6.exchangerate-api.com/v6/6ceecb35181bf79b68dc09cb/pair/";
    private final HttpClient client;

    public ConverterClient(){
        client = HttpClient.newHttpClient();
    }
    public String convertCurrency(String fCode, String sCode, String amount) throws IOException, InterruptedException {
        String completeURL = String.format("%s%s/%s/%s",BASE_URL,fCode,sCode,amount);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(completeURL))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        return  response.body();
    }

}
