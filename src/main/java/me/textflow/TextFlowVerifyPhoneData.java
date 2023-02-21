package me.textflow;

public class TextFlowVerifyPhoneData {
    private  String verificationCode;
    private  Long expires;
    private  String messageText;

    public TextFlowVerifyPhoneData(String verificationCode, Long expires, String messageText) {
        this.verificationCode = verificationCode;
        this.expires = expires;
        this.messageText = messageText;
    }

    public TextFlowVerifyPhoneData() {
        this.verificationCode = "";
        this.expires = 0L;
        this.messageText = "";
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public Long getExpires() {
        return expires;
    }

    public String getMessageText() {
        return messageText;
    }
}
