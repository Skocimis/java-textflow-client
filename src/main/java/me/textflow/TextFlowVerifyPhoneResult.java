package me.textflow;

import org.json.JSONObject;


public class TextFlowVerifyPhoneResult {
    private Boolean ok;
    private Integer status;
    private String message;
    private TextFlowVerifyPhoneData data;

    TextFlowVerifyPhoneResult(Boolean ok, Integer status, String message, TextFlowVerifyPhoneData data) {
        this.ok = ok;
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public TextFlowVerifyPhoneResult(String json){
        JSONObject jsonObject= new JSONObject(json);
        try{
            ok = jsonObject.getBoolean("ok");
            status = jsonObject.getInt("status");
            message = jsonObject.getString("message");
            if(ok){
                JSONObject dataObject = jsonObject.getJSONObject("data");
                data = new TextFlowVerifyPhoneData(dataObject.getString("verification_code"), dataObject.getLong("expires"), dataObject.getString("message_text"));
            }
            else{
                data = new TextFlowVerifyPhoneData();
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            ok = false;
            status = 500;
            message = "Server error. ";
            data = new TextFlowVerifyPhoneData();
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

    public TextFlowVerifyPhoneData getData() {
        return data;
    }
}
