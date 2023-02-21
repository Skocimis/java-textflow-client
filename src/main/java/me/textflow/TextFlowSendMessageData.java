package me.textflow;

public class TextFlowSendMessageData {
    private  String to;
    private  String content;
    private  String countryCode;
    private  Float price;
    private  Long timestamp;

    public TextFlowSendMessageData(String to, String content, String countryCode, Float price, Long timestamp) {
        this.to = to;
        this.content = content;
        this.countryCode = countryCode;
        this.price = price;
        this.timestamp = timestamp;
    }

    public TextFlowSendMessageData() {
        this.to = "";
        this.content = "";
        this.countryCode = "";
        this.price = (float) 0;
        this.timestamp = 0L;
    }

    public String getTo() {
        return to;
    }

    public String getContent() {
        return content;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Float getPrice() {
        return price;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
