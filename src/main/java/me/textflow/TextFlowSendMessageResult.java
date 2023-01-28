package me.textflow;

import org.json.JSONObject;


public class TextFlowSendMessageResult {
    private Boolean ok;
    private Integer status;
    private String message;
    private TextFlowSendMessageData data;

    TextFlowSendMessageResult(Boolean ok, Integer status, String message, TextFlowSendMessageData data) {
        this.ok = ok;
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public TextFlowSendMessageResult(String json){
        JSONObject jsonObject= new JSONObject(json);
        try{
            ok = jsonObject.getBoolean("ok");
            status = jsonObject.getInt("status");
            message = jsonObject.getString("message");
            if(ok){
                JSONObject dataObject = jsonObject.getJSONObject("data");
                data = new TextFlowSendMessageData(dataObject.getString("to"), dataObject.getString("content"), dataObject.getString("country_code"), dataObject.getFloat("price"), dataObject.getLong("to"));
            }
            else{
                data = new TextFlowSendMessageData();
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            ok = false;
            status = 500;
            message = "Server error. ";
            data = new TextFlowSendMessageData();
        }
    }

    public Boolean isOk() {
        return ok;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public TextFlowSendMessageData getData() {
        return data;
    }
}
