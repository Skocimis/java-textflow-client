package me.textflow;

public class TextFlowSendMessageData {
    private  String to;
    private  String content;
    private  String country_code;
    private  Float price;
    private  Long timestamp;

    public TextFlowSendMessageData(String to, String content, String country_code, Float price, Long timestamp) {
        this.to = to;
        this.content = content;
        this.country_code = country_code;
        this.price = price;
        this.timestamp = timestamp;
    }

    public TextFlowSendMessageData() {
        this.to = "";
        this.content = "";
        this.country_code = "";
        this.price = (float) 0;
        this.timestamp = 0L;
    }

    public String getTo() {
        return to;
    }

    public String getContent() {
        return content;
    }

    public String getCountry_code() {
        return country_code;
    }

    public Float getPrice() {
        return price;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
