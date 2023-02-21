package me.textflow;

import org.json.JSONObject;

import java.security.spec.ECField;


public class TextFlowVerifyCodeResult {
    private Boolean ok;
    private Boolean valid;
    private Integer status;
    private String message;
    private String validCode;
    private Long expires;

    public TextFlowVerifyCodeResult(Boolean ok, Boolean valid, Integer status, String message, String validCode, Long expires) {
        this.ok = ok;
        this.valid = valid;
        this.status = status;
        this.message = message;
        this.validCode = validCode;
        this.expires = expires;
    }

    public TextFlowVerifyCodeResult(String json){
        JSONObject jsonObject= new JSONObject(json);
        try{
            ok = jsonObject.getBoolean("ok");
            valid = jsonObject.getBoolean("valid");
            status = jsonObject.getInt("status");
            message = jsonObject.getString("message");
            try {
                validCode =  jsonObject.getString("valid_code");
            }
            catch (Exception e){
                validCode = null;
            }
            try {
                expires =  jsonObject.getLong("expires");
            }
            catch (Exception e){
                expires = null;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            ok = false;
            status = 500;
            message = "Server error. ";
            valid=false;
            validCode="";
        }
    }

    public Boolean isOk() {
        return ok;
    }

    public Boolean isValid() {
        return valid;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getValidCode() {
        return validCode;
    }

    public Long getExpires() {
        return expires;
    }
}
