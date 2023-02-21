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
    public TextFlowSendMessageResult sendSMS(String phoneNumber, String text){
        if (phoneNumber == null || phoneNumber.length() == 0) return new TextFlowSendMessageResult(false, 400, "You have not specified the recipient. ", new TextFlowSendMessageData());
        if (text == null || text.length() == 0) return new TextFlowSendMessageResult(false, 400, "You have not specified the message body. ", new TextFlowSendMessageData());
        if (apiKey == null || apiKey.length() == 0) return new TextFlowSendMessageResult(false, 400, "You have not specified the API key. Specify it by calling the useKey function. ", new TextFlowSendMessageData());



        try {
            String jsonData  = "{\"phone_number\": \""+phoneNumber+"\", \"text\": \""+text+"\"}";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://textflow.me/api/send-sms"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer "+apiKey)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonData, StandardCharsets.UTF_8))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new TextFlowSendMessageResult(response.body());
        }
        catch (Exception e){
            return new TextFlowSendMessageResult("{\"success\": false}");
        }
    }

    public TextFlowVerifyPhoneResult sendVerificationSMS(String phoneNumber){
        return sendVerificationSMS(phoneNumber, null, null);
    }

    public TextFlowVerifyPhoneResult sendVerificationSMS(String phoneNumber, String serviceName){
        return sendVerificationSMS(phoneNumber, serviceName, null);
    }

    public TextFlowVerifyPhoneResult sendVerificationSMS(String phoneNumber, Integer seconds){
        return sendVerificationSMS(phoneNumber, null, seconds);
    }

    public TextFlowVerifyPhoneResult sendVerificationSMS(String phoneNumber, String serviceName, Integer seconds){
        if (phoneNumber == null || phoneNumber.length() == 0) return new TextFlowVerifyPhoneResult(false, 400, "You have not specified the recipient. ", new TextFlowVerifyPhoneData());
        if(serviceName==null) serviceName = "";
        if(seconds==null || seconds==0) seconds = 600;
        if (apiKey == null || apiKey.length() == 0) return new TextFlowVerifyPhoneResult(false, 400, "You have not specified the API key. Specify it by calling the useKey function. ", new TextFlowVerifyPhoneData());



        try {
            String jsonData  = "{\"phone_number\": \""+phoneNumber+"\", \"service_name\": \""+serviceName+"\", \"seconds\": \""+seconds+"\"}";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://textflow.me/api/send-code"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer "+apiKey)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonData, StandardCharsets.UTF_8))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new TextFlowVerifyPhoneResult(response.body());
        }
        catch (Exception e){
            return new TextFlowVerifyPhoneResult("{\"success\": false}");
        }
    }


    public TextFlowVerifyCodeResult verifyCode(String phoneNumber, String code){
        if (phoneNumber == null || phoneNumber.length() == 0) return new TextFlowVerifyCodeResult(false, false, 400, "You have not specified the recipient. ", "", 0L);
        if (code == null || code.length() == 0) return new TextFlowVerifyCodeResult(false, false, 400, "You have not specified the recipient. ", "", 0L);
        if (apiKey == null || apiKey.length() == 0) return new TextFlowVerifyCodeResult(false, false, 400, "You have not specified the API key. Specify it by calling the useKey function. ", "", 0L);

        try {
            String jsonData  = "{\"phone_number\": \""+phoneNumber+"\", \"code\": \""+code+"\"}";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://textflow.me/api/verify-code"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer "+apiKey)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonData, StandardCharsets.UTF_8))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new TextFlowVerifyCodeResult(response.body());
        }
        catch (Exception e){
            return new TextFlowVerifyCodeResult("{\"success\": false}");
        }
    }


}
