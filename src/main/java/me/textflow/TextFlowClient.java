package me.textflow;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class TextFlowClient {
    private String apiKey;

    public TextFlowClient(String apiKey){
        if(apiKey==null) {
            this.apiKey = "";
            return;
        }
        this.apiKey = apiKey;
    }
    public void useKey(String apiKey){
        if(apiKey==null) {
            this.apiKey = "";
            return;
        }
        this.apiKey = apiKey;
    }
    public TextFlowSendMessageResult sendSMS(String recipient, String text){
        if (recipient == null || recipient.length() == 0) return new TextFlowSendMessageResult(false, 400, "You have not specified the recipient. ", new TextFlowSendMessageData());
        if (text == null || text.length() == 0) return new TextFlowSendMessageResult(false, 400, "You have not specified the message body. ", new TextFlowSendMessageData());
        if (apiKey == null || apiKey.length() == 0) return new TextFlowSendMessageResult(false, 400, "You have not specified the API key. Specify it by calling the useKey function. ", new TextFlowSendMessageData());



        try {
            String jsonData  = "{\"recipient\": \""+recipient+"\", \"text\": \""+text+"\", \"apiKey\": \""+apiKey+"\"}";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://textflow.me/messages/send"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonData, StandardCharsets.UTF_8))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new TextFlowSendMessageResult(response.body());
        }
        catch (Exception e){
            return new TextFlowSendMessageResult("asd");
        }
    }
}
