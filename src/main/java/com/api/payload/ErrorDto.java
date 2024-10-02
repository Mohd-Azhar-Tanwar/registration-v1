package com.api.payload;

import java.util.Date;

public class ErrorDto {
    private String meassage;
    private Date date;
    private String uri;

    public ErrorDto(String meassage, Date date, String uri) {
        this.meassage = meassage;
        this.date = date;
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public Date getDate() {
        return date;
    }

    public String getMeassage() {
        return meassage;
    }
}
